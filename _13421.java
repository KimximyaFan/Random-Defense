import java.io.*;
import java.util.*;

public class _13421
{
    static long min = 0;

    static long[] x = { 0, 0, 0, 0 };
    static long[] y = { 0, 0, 0, 0 };

    static long[] sign_x = { 1, 1, -1, -1 };
    static long[] sign_y = { 1, -1, 1, -1 };

    static boolean[] flag = { false, false, false, false };
 
    static long Get_Dist(long x, long y, long end_x, long end_y)
    {
        return Math.abs(end_x - x) + Math.abs(end_y - y);
    }

    static void BackTrack(int depth, long d, long sum)
    {
        if ( depth == 4 )
        {
            min = Math.min(min, sum);
            return;
        }
            
        for (int i=0; i<4; i++)
        {
            if ( flag[i] == true )
                continue;

            flag[i] = true;
            long dist = Get_Dist(x[depth], y[depth], sign_x[i] * d, sign_y[i] * d);
            sum += dist;
            BackTrack(depth+1, d, sum);
            sum -= dist;
            flag[i] = false;
        }
    }

    static long Calculate(long d)
    {
        min = Long.MAX_VALUE;
        BackTrack(0, d, 0);
        return min; 
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long maxAbs = 0;

        for (int i=0; i<4; i++)
        {
            st = new StringTokenizer(input.readLine());

            x[i] = Long.parseLong(st.nextToken())*2;
            y[i] = Long.parseLong(st.nextToken())*2;
            
            maxAbs = Math.max( Math.abs(x[i]), maxAbs);
            maxAbs = Math.max( Math.abs(y[i]), maxAbs);
        }

        long left = 1;
        long right = Math.max(1, maxAbs);
        
        while (right - left > 6)
        {
            long m1 = left + (right - left) / 3;
            long m2 = right - (right - left) / 3;
            long c1 = Calculate(m1);
            long c2 = Calculate(m2);

            if (c1 < c2)
                right = m2 - 1;
            else if (c1 > c2)
                left = m1 + 1;
            else
                left = m1 + 1;
        }

        long best_left = 0;
        long min_value = Long.MAX_VALUE;

        for (long i=left; i<=right; i++)
        {
            long cand = Calculate(i);

            if ( cand <= min_value )
            {
                best_left = i;
                min_value = cand;
            }
        }

        System.out.print(best_left);
    }
}