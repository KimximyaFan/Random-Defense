import java.io.*;
import java.util.*;

public class G1_11574
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int MOD = 1000000007;
        long ans = 0;
        long[] dp = new long[N+1];

        if ( K == 1 )
            ans = 1;
        else if ( K == 2 )
        {   
            dp[1] = 2;

            for (int i=1; i<N; i++)
                dp[i+1] = ( (i+2)*dp[i] ) % MOD;

            ans = dp[N];
        }
        else
        {
            dp[1] = 3;

            for (int i=1; i<N; i++)
                dp[i+1] = ( (2*i+3)*dp[i] ) % MOD;
            
            ans = dp[N];
        }

        System.out.print(ans);
    }
}