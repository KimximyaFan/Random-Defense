import java.io.*;
import java.util.*;

public class G3_2342
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int index = -1;
        int MAX = 10000000;
        int ans = MAX;

        int[][][] dp = new int[100001][5][5];

        for (int i=0; i<100001; i++)
            for (int j=0; j<5; j++)
                for (int k=0; k<5; k++)
                    dp[i][j][k] = MAX;

        dp[0][0][0] = 0;

        st = new StringTokenizer(input.readLine());
        
        while (true)
        {
            index++;

            int next_step = Integer.parseInt(st.nextToken());

            if ( next_step == 0 )
                break;

            for (int left=0; left<5; left++)
            {
                for (int right=0; right<5; right++)
                {
                    if ( left != 0 && left == right )
                        continue;

                    if ( dp[index][left][right] == MAX )
                        continue;

                    dp[index+1][next_step][right] = Math.min( dp[index+1][next_step][right], dp[index][left][right] + Get_Required_Power(left, next_step) );
                    dp[index+1][left][next_step] = Math.min( dp[index+1][left][next_step], dp[index][left][right] + Get_Required_Power(right, next_step) );
                }
            }
        }

        for (int left=0; left<5; left++)
            for (int right=0; right<5; right++)
                ans = Math.min(ans, dp[index][left][right]);

        System.out.print(ans);
    }

    static int Get_Required_Power (int current_step, int next_step)
    {
        if ( current_step == 0 )
            return 2;

        if ( current_step == next_step )
            return 1;

        if ( Math.abs(next_step - current_step) % 2 == 1 )
            return 3;
        else
            return 4;
    }
}