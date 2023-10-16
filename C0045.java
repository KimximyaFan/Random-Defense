import java.util.*;
import java.io.*;

public class C0045
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N1 = Integer.parseInt(st.nextToken());
        int D1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());

        int N2 = Integer.parseInt(st.nextToken());
        int D2 = Integer.parseInt(st.nextToken());

        int N = N1*D2 + N2*D1;
        int D = D1*D2;

        int gcd = GCD(N, D);

        System.out.print( N/gcd + " " + D/gcd );
    }

    static public int GCD (int a, int b)
    {
        if ( b > a )
            return GCD(b, a);
        
        if ( a % b == 0 )
            return b;
        else
            return GCD(b, a % b);
    }
}