import java.io.*;
import java.util.*;

public class C0026
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());

        int y1 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int dy = Math.abs(y1 - y2);

        st = new StringTokenizer(input.readLine());

        int[] P = new int[N];
        int[] Q = new int[M];

        for (int i=0; i<N; i++)
            P[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<M; i++)
            Q[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(P);
        Arrays.sort(Q);

        if ( M < N )
        {
            int[] temp = P;

            P = Q;
            Q = temp;
        }

        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i=0; i<P.length; i++)
        {
            int left = 0;
            int right = Q.length-1;
            int mid = (left + right)/2;

            while ( left < mid || mid < right )
            {
                if ( P[i] < Q[mid] )
                {
                    right = mid - 1;
                    mid = (left + right)/2;
                }
                else if ( P[i] == Q[mid] )
                    break;
                else if ( Q[mid] < P[i] )
                {

                    left = mid + 1;
                    mid = (left + right)/2;
                }
            }

            int d = Math.abs(P[i] - Q[mid]);

            if ( d < min )
            {
                min = d;
                count = 1;
            }
            else if ( d == min )
                count++;
            
            if ( mid-1 >= 0)
            {
                d = Math.abs(P[i] - Q[mid-1]);

                if ( d < min )
                {
                    min = d;
                    count = 1;
                }
                else if ( d == min )
                    count++;
            }

            if ( mid + 1 <= Q.length-1 )
            {
                d = Math.abs(P[i] - Q[mid+1]);

                if ( d < min )
                {
                    min = d;
                    count = 1;
                }
                else if ( d == min )
                    count++;
            }
        }

        output.write(dy + min + " " + count);
        output.close();
    }
}