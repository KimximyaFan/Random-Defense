import java.io.*;
import java.util.*;

public class C0014
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        HashSet<Integer> Set = new HashSet<>();

        int[][] A = new int[2][K+1];

        for (int i=1; i<N; i++)
            Set.add( 65 + i );

        for (int i=1; i<=K; i++)
        {
            st = new StringTokenizer(input.readLine());
            A[0][i] = Integer.parseInt(st.nextToken());
            A[1][i] = st.nextToken().charAt(0);
        }

        for (int i=Q; i<=K; i++)
        {
            if ( A[0][i] == 0 )
                Set.removeAll(Set);
            else
                Set.remove(A[1][i]);
        }

        if ( A[0][Q] == A[0][Q-1] )
            Set.remove(A[1][Q-1]);
        
        if ( Set.isEmpty() == true )
            output.write("-1");
        else
        {
            Iterator<Integer> iter = Set.iterator();

            while (iter.hasNext())
            {
                int temp = iter.next();
                char c = (char)temp;

                output.write( c + " ");
            }
        }

        output.close();
    }
}