import java.io.*;
import java.util.*;

public class C0037
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        int M = Integer.parseInt(input.readLine());
        int[][] A = new int[N+1][N+1];
        int[][] parent = new int[N+1][N+1];
        int MAX = 100000000;

        for (int i=1; i<=N; i++)
        {
            for (int j=1; j<=N; j++)
            {
                if ( i != j )
                    A[i][j] = MAX;
                
                parent[i][j] = -1;
            }
        }

        for (int i=0; i<M; i++)
        {
            st = new StringTokenizer(input.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if ( c < A[a][b] )
            {
                A[a][b] = c;
                parent[a][b] = a;
            }
                
        }

        for (int k=1; k<=N; k++)
        {
            for (int i=1; i<=N; i++)
            {
                for (int j=1; j<=N; j++)
                {
                    if ( A[i][k] + A[k][j] < A[i][j] )
                    {
                        A[i][j] = A[i][k] + A[k][j];
                        // parent[i][j] = k;
                        parent[i][j] = parent[k][j];
                    }
                }
                    
            }
        }

        for (int i=1; i<=N; i++)
        {
            for (int j=1; j<=N; j++)
            {
                if ( A[i][j] == MAX )
                    output.write("0 ");
                else
                    output.write( A[i][j] + " " );
            }
            output.write("\n");
        }

        for (int i=1; i<=N; i++)
        {
            for (int j=1; j<=N; j++)
            {
                int x = j;
                int count = 0;
                StringBuilder S = new StringBuilder();

                while ( parent[i][x] != -1 )
                {
                    S.insert(0, x + " ");
                    count++;
                    x = parent[i][x];
                }
                S.insert(0, x + " ");
                count++;

                if ( count == 1 )
                    output.write("0\n");
                else
                {
                    S.insert(0, count + " ");
                    output.write( S.toString() + "\n");
                }
            }
        }

        output.close();
    }
}