import java.io.*;
import java.util.*;

public class S5_15157
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        int min = 5000000;

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
        {
            int current_candy = Integer.parseInt(st.nextToken());

            if ( current_candy < min )
                min = current_candy;
            
            sb.append(min).append(" ");

            min++;
        }

        System.out.print(sb);
    }
}