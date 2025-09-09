import java.io.*;

public class S4_14468
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String s = input.readLine();

        boolean[][] matching = new boolean[26][26];

        int count = 0;

        for (int i=0; i<26; i++)
        {
            boolean flag = false;

            for (int j=0; j<s.length(); j++)
            {
                if ( flag == true )
                    matching[i][s.charAt(j) - 'A'] = true;

                if ( s.charAt(j) - 'A' == i )
                {
                    if ( flag == true )
                        break;

                    flag = true;
                }
            }
        }

        for (int i=0; i<26; i++)
        {
            for (int j=i+1; j<26; j++)
            {
                if ( matching[i][j] == true && matching[j][i] == true )
                    count++;
            }
        }

        System.out.print(count);
    }
}