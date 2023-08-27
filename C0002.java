import java.io.*;
import java.util.*;

public class C0002 
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(input.readLine());

        int[] A = new int[n];
        int[] dp = new int[n];
        int max = 1;

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<n; i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;

            for (int j=0; j<i; j++)
            {
                if ( A[i] < A[j] && (dp[j] + 1) > dp[i] )
                {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
        output.write(max + "");
        output.close();
    }
}
