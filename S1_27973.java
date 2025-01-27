import java.io.*;
import java.util.*;

public class S1_27973
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int Q = Integer.parseInt(input.readLine());
        long smallest = 1;
        long gap = 1;

        while ( Q-- > 0 )
        {
            st = new StringTokenizer(input.readLine());

            int order = Integer.parseInt(st.nextToken());

            if ( order == 0 )
                smallest += Long.parseLong(st.nextToken());
            
            else if ( order == 1 )
            {
                long multiply = Long.parseLong(st.nextToken());
                gap *= multiply;
                smallest *= multiply;
            }
                

            else if ( order == 2 )
            {
                long n = Long.parseLong(st.nextToken());
                smallest += n * gap;
            }
            else
                sb.append(smallest).append("\n");
        }

        System.out.print(sb);
    }
}