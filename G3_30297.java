import java.io.*;
import java.util.*;

public class G3_30297
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(input.readLine());

        while ( T--> 0 )
        {
            int N = Integer.parseInt(input.readLine());

            int count = 0;

            int max = 0;

            int[] map = new int[N+1];

            StringBuilder temp = new StringBuilder();

            st = new StringTokenizer(input.readLine());

            for (int i=1; i<=N; i++)
                map[i] = Integer.parseInt(st.nextToken());

            for (int i=1; i<N; i++)
            {
                max = Math.max(max, map[i]);
                
                if ( max <= i )
                {
                    count++;
                    temp.append(i).append(" ");
                }
            }

            temp.insert(0, count + "\n");
            temp.append("\n");
            sb.append(temp);
        }

        System.out.print(sb);
    }
}