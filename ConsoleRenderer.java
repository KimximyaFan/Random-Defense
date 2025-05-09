import java.util.Arrays;

public class ConsoleRenderer {
    // 원본 버퍼 해상도
    static final int WIDTH  = 500;
    static final int HEIGHT = 500;
    static char[][] buffer = new char[HEIGHT][WIDTH];

    // 출력 시 샘플링 간격 (500×500 원본 → 약 (500/sampleStep)² 콘솔 출력)
    static final int SAMPLE_STEP = 6;

    // 3D 벡터 (동차 좌표)
    static class Vec4 {
        double x, y, z, w;
        Vec4(double x, double y, double z, double w) {
            this.x = x; this.y = y; this.z = z; this.w = w;
        }
    }

    // 4×4 행렬
    static class Mat4 {
        double[][] m = new double[4][4];
        Mat4(double[][] vals) { m = vals; }
        // 행렬 × 벡터
        Vec4 mul(Vec4 v) {
            double[] r = new double[4];
            for (int i = 0; i < 4; i++)
                r[i] = m[i][0]*v.x + m[i][1]*v.y + m[i][2]*v.z + m[i][3]*v.w;
            return new Vec4(r[0], r[1], r[2], r[3]);
        }
        // 행렬 × 행렬
        Mat4 mul(Mat4 o) {
            double[][] r = new double[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    r[i][j] = 0;
                    for (int k = 0; k < 4; k++)
                        r[i][j] += m[i][k] * o.m[k][j];
                }
            }
            return new Mat4(r);
        }
        // 단위행렬 생성
        static Mat4 identity() {
            double[][] id = new double[4][4];
            for (int i = 0; i < 4; i++) id[i][i] = 1;
            return new Mat4(id);
        }
    }

    // 버퍼를 공백으로 초기화
    static void clearBuffer() {
        for (char[] row : buffer)
            Arrays.fill(row, ' ');
    }

    // 브레젠험 선분 그리기
    static void drawLine(int x0, int y0, int x1, int y1, char c) {
        int dx = Math.abs(x1 - x0), sx = x0 < x1 ? 1 : -1;
        int dy = Math.abs(y1 - y0), sy = y0 < y1 ? 1 : -1;
        int err = dx - dy;
        while (true) {
            if (x0 >= 0 && x0 < WIDTH && y0 >= 0 && y0 < HEIGHT)
                buffer[y0][x0] = c;
            if (x0 == x1 && y0 == y1) break;
            int e2 = err * 2;
            if (e2 > -dy) { err -= dy; x0 += sx; }
            if (e2 <  dx) { err += dx; y0 += sy; }
        }
    }

    public static void main(String[] args) {
        // 1) 단위 큐브 버텍스 (center at origin)
        Vec4[] vertices = {
            new Vec4(-1, -1, -1, 1), new Vec4( 1, -1, -1, 1),
            new Vec4( 1,  1, -1, 1), new Vec4(-1,  1, -1, 1),
            new Vec4(-1, -1,  1, 1), new Vec4( 1, -1,  1, 1),
            new Vec4( 1,  1,  1, 1), new Vec4(-1,  1,  1, 1)
        };
        int[][] edges = {
            {0,1},{1,2},{2,3},{3,0},  // back face
            {4,5},{5,6},{6,7},{7,4},  // front face
            {0,4},{1,5},{2,6},{3,7}   // connectors
        };

        // 2) 변환 매트릭스 준비
        Mat4 model = Mat4.identity();
        // (필요시 model에 회전/스케일 행렬을 곱해 회전하는 큐브 구현 가능)

        // 카메라: z축 뒤로 5 이동
        Mat4 view = Mat4.identity();
        view.m[2][3] = 5;

        // 원근 투영(projection)
        double fov = Math.toRadians(90);
        double aspect = (double) WIDTH / HEIGHT;
        double near = 1, far = 10;
        double f = 1.0 / Math.tan(fov / 2.0);
        Mat4 proj = new Mat4(new double[][] {
            {f / aspect,  0,                           0,                          0},
            {          0,  f,                           0,                          0},
            {          0,  0,   (far + near) / (near - far), (2 * far * near) / (near - far)},
            {          0,  0,                          -1,                          0}
        });

        // 합성 MVP
        Mat4 mvp = proj.mul(view).mul(model);

        // 3) 버퍼 클리어 & 변환 → 투영 → 스크린 좌표로 매핑 → 선 그리기
        clearBuffer();
        Vec4[] projected = new Vec4[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            // 모델뷰투영
            Vec4 v = mvp.mul(vertices[i]);
            // 호모지니어스 나누기
            v.x /= v.w; v.y /= v.w;
            // NDC(-1..1) → 스크린(0..WIDTH-1, 0..HEIGHT-1)
            int sx = (int) ((v.x + 1) * 0.5 * (WIDTH  - 1));
            int sy = (int) ((1 - v.y) * 0.5 * (HEIGHT - 1));
            projected[i] = new Vec4(sx, sy, v.z, 1);
        }
        for (int[] e : edges) {
            Vec4 a = projected[e[0]], b = projected[e[1]];
            drawLine((int) a.x, (int) a.y, (int) b.x, (int) b.y, '*');
        }

        // 4) 콘솔에 샘플링하여 출력
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < HEIGHT; y += SAMPLE_STEP) {
            sb.setLength(0);
            for (int x = 0; x < WIDTH; x += SAMPLE_STEP) {
                sb.append(buffer[y][x]);
            }
            System.out.println(sb);
        }
    }
}
