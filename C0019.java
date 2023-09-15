import java.io.*;
import java.util.*;

public class C0019
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int S = 0;
        int V = 0;

        PriorityQueue<Integer> C = new PriorityQueue<>();

        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(input.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if ( A > B )
            {
                S += 5000;
                V += A;
                C.add(A-B);
            }
            else
            {
                S += 1000;
                V += B;
            }
        }

        while ( S > X )
        {
            S -= 4000;
            V -= C.poll();
        }

        output.write(V + "");
        output.close();
    }
}