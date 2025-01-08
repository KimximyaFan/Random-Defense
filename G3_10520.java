import java.io.*;
import java.util.*;

public class G3_10520
{
    static int[] prefix_sum;
    static int MAX_NUM = 100000000;
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int ans = MAX_NUM;
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][d+2];
        prefix_sum = new int[n+1];

        st = new StringTokenizer(input.readLine());

        for (int i=1; i<=n; i++)
        {
            prefix_sum[i] = prefix_sum[i-1] + Integer.parseInt(st.nextToken());
            dp[i][0] = MAX_NUM;
        }
            
        for (int j=1; j<=d+1; j++)
        {
            for (int i=1; i<=n; i++)
            {
                int min = MAX_NUM;

                for (int k=0; k<i; k++)
                {
                    int value = dp[k][j-1] + Round_Cost(Get_Sum(i, k+1));

                    if ( value < min )
                        min = value;
                }

                dp[i][j] = min;
            }
        }

        for (int i=1; i<=d+1; i++)
        {
            if ( dp[n][i] < ans )
                ans = dp[n][i];
        }

        System.out.print(ans);
    }

    static int Get_Sum (int n, int k)
    {
        return prefix_sum[n] - prefix_sum[k-1];
    }

    static int Round_Cost (int x)
    {
        return ( (x + 5) / 10 ) * 10;
    }
}