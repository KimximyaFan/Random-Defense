import java.io.*;
import java.util.*;

public class C0055
{
    static class point
    {
        int x, y;
        point (int x, int y) { this.x = x; this.y = y; }
    }
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        point[] A = new point[3];

        for (int i=0; i<3; i++)
        {
            st = new StringTokenizer(input.readLine());

            A[i] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.print(CCW(A[0],A[1],A[2]));
    }

    static int CCW (point A, point B, point C)
    {
        int a = A.x * B.y + B.x * C.y + C.x * A.y;
        int b = A.x * C.y + C.x * B.y + B.x * A.y;

        if ( a-b > 0)
            return 1;
        else if ( a-b == 0 )
            return 0;
        else
            return -1;
    }
}