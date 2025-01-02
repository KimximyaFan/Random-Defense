import java.io.*;

public class S2_17213 
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(input.readLine());

        int M = Integer.parseInt(input.readLine());

        int r = M - N;

        System.out.print(nHr(N, r));
    }

    public static int nHr (int n, int r)
    {
        return nCr(n + r - 1, r);
    }

    public static int nCr (int n, int r)
    {
        if ( r == 0 || r == n )
            return 1;

        r = Math.min(r, n - r);

        long result = 1;

        for (int i = 0; i<r; i++)
        {
            result *= (n-i);
            result /= (i + 1);
        }

        return (int)result;
    }
}