import java.io.*;
import java.util.*;

public class C0057
{
    static class point
    {
        long x, y;
        point (long x, long y) { this.x = x; this.y = y; }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        point A = new point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        point B = new point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        st = new StringTokenizer(input.readLine());

        point C = new point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        point D = new point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        if ( CCW(A, B, C) * CCW(A, B, D) < 0 && CCW(C, D, A) * CCW(C, D, B) < 0 )
            System.out.print("1");
        else
            System.out.print("0");
    }

    static int CCW (point A, point B, point C)
    {
        long a = A.x*B.y + B.x*C.y + C.x*A.y;
        long b = A.x*C.y + C.x*B.y + B.x*A.y;

        if ( a - b > 0 )
            return 1;
        else
            return -1;
    }
}