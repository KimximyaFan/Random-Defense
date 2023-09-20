import java.io.*;
import java.util.*;

public class C0024
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        int[] A = new int[N];
        int[] S = new int[N];

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        
        S[0] = A[0];

        int value = S[0];
        int from = 0;

        for (int i=1; i<N; i++)
        {
            int a = (value + from) % N;

            while ( S[a] != 0 )
                a = (a + 1) % N;
            
            S[a] = A[i];

            value = S[a];
            from = a;
        }

        output.write( N + "\n");

        for (int i=0; i<N; i++)
            output.write(S[i] + " ");
        
        output.close();
    }
}