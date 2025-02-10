import java.io.*;
import java.util.*;

public class G2_20207_2
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        int[] calendar = new int[367];

        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(input.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            calendar[start]++;
            calendar[end+1]--;
        }

        int height = 0;
        int width = 0;
        int ans = 0;

        for (int i=1; i<=366; i++)
        {
            if ( calendar[i] == 0 )
            {
                ans += width * height;
                width = 0;
                height = 0;
            }
            else
            {
                calendar[i+1] += calendar[i];
                width++;
                height = Math.max(height, calendar[i]);
            }
        }

        System.out.print(ans);
    }
}