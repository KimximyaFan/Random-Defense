import java.io.*;
import java.util.*;

public class C0010
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(input.readLine());

        while ( T-- > 0 )
        {
            st = new StringTokenizer(input.readLine());

            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken()) / 45;

            int[][] A = new int[N][N];

            for (int i=0; i<N; i++)
            {
                st = new StringTokenizer(input.readLine());

                for (int j=0; j<N; j++)
                    A[i][j] = Integer.parseInt(st.nextToken());
            }

            int[][] B = new int[4][N];

            for (int i=0; i<N; i++)
            {
                B[0][i] = A[N/2][i];
                B[1][i] = A[i][i];
                B[2][i] = A[i][N/2];
                B[3][i] = A[i][N-i-1];
            }

            for (int i=0; i<4; i++)
            {
                int X = i + R;
                
                if ( X < 0 )
                    X += 8;
                else if ( X > 7)
                    X -= 8;
                
                for (int j=0; j<N; j++)
                {
                    if ( X == 0 )
                        A[N/2][j] = B[i][j];
                    else if ( X == 1 )
                        A[j][j] = B[i][j];
                    else if ( X == 2 )
                        A[j][N/2] = B[i][j];
                    else if ( X == 3 )
                        A[j][N-j-1] = B[i][j];
                    else if ( X == 4 )
                        A[N/2][N-j-1] = B[i][j];
                    else if ( X == 5 )
                        A[N-j-1][N-j-1] = B[i][j];
                    else if ( X == 6 )
                        A[N-j-1][N/2] = B[i][j];
                    else if ( X == 7 )
                        A[N-j-1][j] = B[i][j];
                }
            }

            for (int i=0; i<N; i++)
            {
                for (int j=0; j<N; j++)
                    output.write(A[i][j] + " ");
                output.write("\n");
            }
        }

        output.close();
    }
}