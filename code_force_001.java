import java.io.*;

public class code_force_001
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(input.readLine());

        while (T-- > 0)
        {
            int N = Integer.parseInt(input.readLine());
            String s = input.readLine();

            int count_0 = 0;
            int len = 0;
            int how_many = 0;

            for (int i=0; i<N; i++)
            {
                if ( s.charAt(i) == '0' )
                    count_0++;
            }

            len = N - count_0;

            for (int i=N-1; i>=N-len; i--)
            {
                if ( s.charAt(i) == '0' )
                    how_many++;
            }

            sb.append(how_many).append("\n");
        }

        System.out.print(sb);
    }
}