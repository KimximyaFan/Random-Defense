import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class G5_3793
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        List<String> tokens = new ArrayList<>();

        while(true) 
        {
            String line = input.readLine();

            if(line == null) {
                break;
            }

            line = line.trim();
            if(line.isEmpty()) {
                continue;
            }

            String[] arr = line.split("\\s+");

            for(String w : arr) {
                tokens.add(w);
            }
        }

        for(int i = 0; i+1 < tokens.size(); i += 2) {
            String a = tokens.get(i);
            String b = tokens.get(i+1);
            sb.append(LCS(a, b)).append("\n");
        }

        System.out.print(sb);   
    }

    static int LCS (String a, String b)
    {
        a = "_" + a;
        b = "_" + b;

        int[][] dp = new int[a.length()][b.length()];

        for (int i=1; i<a.length(); i++)
        {
            for (int j=1; j<b.length(); j++)
            {
                if ( a.charAt(i) == b.charAt(j) )
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[a.length()-1][b.length()-1];
    }   
}