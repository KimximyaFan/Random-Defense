import java.io.*;
import java.util.*;

public class S2_3976
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(input.readLine());

        while (T-- > 0)
        {
            st = new StringTokenizer(input.readLine());

            int N = Integer.parseInt(st.nextToken());
            int l1 = Integer.parseInt(st.nextToken());
            int l2 = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            int[] pass1 = new int[N-1];
            int[] dribble1 = new int[N-1];
            int[] pass2 = new int[N-1];
            int[] dribble2 = new int[N-1];
            int[][] dp = new int[N][2];
            
            st = new StringTokenizer(input.readLine());

            for (int i=0; i<N-1; i++)
                pass1[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(input.readLine());

            for (int i=0; i<N-1; i++)
                dribble1[i] = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(input.readLine());

            for (int i=0; i<N-1; i++)
                pass2[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(input.readLine());

            for (int i=0; i<N-1; i++)
                dribble2[i] = Integer.parseInt(st.nextToken());

            dp[0][0] = l1;
            dp[0][1] = l2;

            for (int i=1; i<N; i++)
            {
                dp[i][0] = Math.min(dp[i-1][0] + dribble1[i-1], dp[i-1][1] + pass2[i-1]);
                dp[i][1] = Math.min(dp[i-1][0] + pass1[i-1], dp[i-1][1] + dribble2[i-1]);
            }

            sb.append(Math.min(dp[N-1][0] + s1, dp[N-1][1] + s2)).append("\n");
        }

        System.out.print(sb);
    }

}