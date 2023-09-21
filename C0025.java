import java.io.*;
import java.util.*;

public class C0025
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());
        
        long i = 1;
        long N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long left = 1;
        long right = N;
        long mid = (left + right) / 2;
        
        boolean isPossible = false;

        while ( true )
        {
            i = (N + 2) - mid;

            long temp = mid * i;

            if ( temp == K )
            {
                isPossible = true;
                break;
            }

            if ( mid == left || mid == right)
                break;

            if ( temp < K )
            {
                if ( (mid + right)/2 == mid )
                    mid++;
                else
                {
                    left = mid;
                    mid = (mid + right) / 2;
                }
                    
            }

            if ( K < temp )
            {
                right = mid;
                mid = (left + mid) / 2;
            }
        }

        if ( isPossible == true )
            output.write("YES");
        else
            output.write("NO");
        
        output.close();
    }
}