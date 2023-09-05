import java.io.*;
import java.util.*;

public class C0011
{
    static int N, R;
    static int[][] A;
    static int[][] Temp;

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(input.readLine());

        while ( T-- > 0 )
        {
            st = new StringTokenizer(input.readLine());

            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken()) / 45;
            R = R < 0 ? R + 8 : R;

            A = new int[N][N];
            Temp = new int[N][N];

            for (int i=0; i<N; i++)
            {
                st = new StringTokenizer(input.readLine());

                for (int j=0; j<N; j++)
                {
                    A[i][j] = Integer.parseInt(st.nextToken());
                    Temp[i][j] = A[i][j];
                }
            }

            while (R-- > 0) { Rotate(); }

            for (int i=0; i<N; i++)
            {
                for (int j=0; j<N; j++)
                    output.write(A[i][j] + " ");
                output.write("\n");
            }
        }

        output.close();
    }

    static void Rotate()
    {
        for (int i=0; i<N; i++)
        {
            Temp[i][i] = A[N/2][i];
            Temp[i][N/2] = A[i][i];
            Temp[i][N-i-1] = A[i][N/2];
            Temp[N/2][N-i-1] = A[i][N-i-1];
        }

        for (int i=0; i<N; i++)
        {
            A[i][i] = Temp[i][i];
            A[i][N/2] = Temp[i][N/2];
            A[i][N-i-1] = Temp[i][N-i-1];
            A[N/2][N-i-1] = Temp[N/2][N-i-1];
        }
    }
}
