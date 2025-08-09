import java.io.*;
import java.util.*;

public class G4_27979
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        int[] num = new int[N];
        boolean[] flag = new boolean[N];

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        int count = 0;
        int max = 0;
        int mono_increase = num[0];

        for (int i=1; i<N; i++)
        {
            if ( num[i] < mono_increase )
            {
                max = Math.max(max, num[i]);
                flag[i] = true;
                count++;
            }
            else
                mono_increase = num[i];
        }

        for (int i=0; i<N; i++)
        {
            if ( num[i] < max && flag[i] == false )
                count++;
        }

        System.out.print(count);
    }
}