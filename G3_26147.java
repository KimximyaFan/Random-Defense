import java.io.*;
import java.util.*;

public class G3_26147
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(input.readLine());

        char[] ans = { 'A', 'B', 'C', 'D', 'E' };
        boolean[] is_matched = { false, false, false ,false ,false };
        boolean global_flag = true;

        sb.append(ans).append("\n");

        for (int i=0; i<N; i++)
        {
            String s = input.readLine();

            if ( global_flag == false )
                continue;

            char[] cand = { 0, 0, 0, 0, 0 };
            Arrays.fill(is_matched, false);

            for (int j=0; j<5; j++)
            {
                char current_char = s.charAt(j);

                switch (current_char)
                {
                    case 'B':
                        cand[j] = 'H';
                        break;
                    case 'G':
                        cand[j] = ans[j];
                        is_matched[j] = true;
                        break;
                    default:
                        break;
                }
            }

            for (int j=0; j<5; j++)
            {
                char current_char = s.charAt(j);

                if ( current_char != 'Y' )
                    continue;

                boolean flag = false;

                for (int k=4; k>=0; k--)
                {
                    if ( k == j || is_matched[k] == true )
                        continue;

                    is_matched[k] = true;
                    cand[j] = ans[k];
                    flag = true;
                    break;
                }

                if ( flag == false )
                {
                    global_flag = false;
                    break;
                }
            }

            sb.append(cand).append("\n");
        }

        if ( global_flag == true )
            System.out.print(sb);
        else
            System.out.print("IMPOSSIBLE");
    }
}