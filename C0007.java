import java.io.*;

public class C0007
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(input.readLine());
        long B = 0;
        long[] DP = new long[N+1];

        for (int i=1; i<=N; i++)
        {
            long a = DP[i-1] + 1;
            long b = DP[i-1] + B;
            long c = 0;
            long d = 0;

            if ( i >= 3 )
                c = 2 * DP[i-3];
            
            if ( i >= 4 )
                d = 3 * DP[i-4];
            
            if ( d >= a && d >= b && d > c)
            {
                DP[i] = d;
                B = DP[i-4];
            }
            else if ( c >= a && c >= b )
            {
                DP[i] = c;
                B = DP[i-3];
            }
            else if ( b >= a )
                DP[i] = b;
            else
                DP[i] = a;
        }

        output.write(DP[N] + "");
        output.close();
    }
}
