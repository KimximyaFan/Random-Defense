import java.io.*;
import java.util.*;

public class C0040
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        long WX_sum = 0;
        long W_sum = 0;

        long[] X = new long[N];
        long[] W = new long[N];

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
            X[i] = Long.parseLong(st.nextToken());
        
        st = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
        {
            W[i] = Long.parseLong(st.nextToken());
            WX_sum += X[i]*W[i];
            W_sum += W[i];
        }
        
        System.out.printf("%.10f", (double)WX_sum / W_sum );
    }
}