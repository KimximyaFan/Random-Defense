import java.io.*;

public class S1_12660
{
    static String main_str = "welcome to code jam";

    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int case_count = 0;

        while (N--> 0)
        {
            String input_str = br.readLine();
            
            case_count++;

            sb.append("Case #").append(case_count)
            .append(": ").append(String.format("%04d", DP(input_str) % 10000)).append("\n");
        }

        System.out.print(sb);
    }

    static int DP (String input)
    {
        if ( input.length() < main_str.length() )
            return 0;

        int[][] dp = new int[input.length()+1][main_str.length()+1];

        dp[0][0] = 1;

        for (int i=1; i<=input.length(); i++)
            dp[i][0] = 1;

        for (int i=1; i<=input.length(); i++)
        {
            for (int j=1; j<=main_str.length(); j++)
            {
                if ( input.charAt(i-1) == main_str.charAt(j-1) )
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];

                dp[i][j] = dp[i][j] % 10000;
            }
        }

        return dp[input.length()][main_str.length()];
    }
}