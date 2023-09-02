import java.io.*;
import java.util.*;

public class C0006
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int count = 0;
        int ans = 0;
        int sum = 0;
        int[] A = new int[N];

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        
        for (int i=0; i<N; i++)
        {
            sum += A[i];

            if ( count < L )
                count++;
            else
                sum -= A[i-L];

            if ( 129 <= sum && sum <= 138)
                ans++;
        }

        output.write( ans + "" );
        output.close();
    }
}
