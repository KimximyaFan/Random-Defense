import java.io.*;

public class G4_10772
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        int k = Integer.parseInt(input.readLine());

        System.out.print(Number_Partition_Generic(n, k));
    }

    static int Number_Partition_Generic (int N, int K)
    {
        int[][] dp = new int[N+1][K+1];
        dp[0][0] = 1;
        
        for (int i=1; i<=N; i++)
        {
            for (int j=1; j<=K; j++)
            {
                int value_1 = dp[i-1][j-1];
                int value_2 = i-j > 0 ? dp[i-j][j] : 0;

                dp[i][j] = value_1 + value_2;
            }
        }

        return dp[N][K];
    }
}


