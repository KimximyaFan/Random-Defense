import java.io.*;
import java.util.*;

public class C0005
{
    static int[][] A;
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        A = new int[N][M];

        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(input.readLine());

            for (int j=0; j<M; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        int T = Integer.parseInt(input.readLine());

        for (int i=0; i<N-2; i++)
        {
            for (int j=0; j<M-2; j++)
            {
                if ( check(i, j) >= T )
                    count++;
            }
        }

        output.write( count + "" );
        output.close();
    }

    static int check (int n, int m)
    {
        int[] B = new int[9];
        int count = 0;

        for (int i=n; i<=n+2; i++)
        {
            for (int j=m; j<=m+2; j++)
            {
                B[count] = A[i][j];
                count++;
            }
        }

        Arrays.sort(B);

        return B[4];
    }
}
