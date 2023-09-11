import java.io.*;
import java.util.*;

public class C0016
{
    static int N, M, count;
    static int[][] A;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static class pair
    {
        int x, y;
        pair () {}
        pair (int x, int y) { this.x = x; this.y = y; }
    }
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = 0;

        A = new int[N][M];

        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(input.readLine());

            for (int j=0; j<M; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++)
        {
            for (int j=0; j<M; j++)
            {
                if (A[i][j] == 0)
                {
                    count++;
                    bfs(i, j);
                }
            }
        }

        output.write( count + "" );
        output.close();
    }

    public static void bfs (int x, int y)
    {
        Queue<pair> Q = new LinkedList<>();

        A[x][y] = 1;
        Q.add(new pair(x, y));

        while ( !Q.isEmpty() )
        {
            pair P = Q.poll();

            int a = P.x;
            int b = P.y;

            for (int i=0; i<4; i++)
            {
                int s = a + dx[i];
                int t = b + dy[i];

                if ( s == -1 )
                    s = N-1;
                else if ( s == N )
                    s = 0;
                else if ( t == -1 )
                    t = M-1;
                else if (t == M )
                    t = 0;
                
                if ( A[s][t] == 0 )
                {
                    A[s][t] = 1;
                    Q.add(new pair(s, t));
                }
            }
        }
    }
}