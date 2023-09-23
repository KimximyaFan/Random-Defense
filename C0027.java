import java.io.*;
import java.util.*;

public class C0027
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st, st2;

        int N = Integer.parseInt(input.readLine());

        int[] L = new int[N];
        int[] R = new int[N];
        int[][] DP = new int[N+1][N+1];
        boolean[][] V = new boolean[N+1][N+1];
        int max = 0;

        st = new StringTokenizer(input.readLine());
        st2 = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
        {
            L[i] = Integer.parseInt(st.nextToken());
            R[i] = Integer.parseInt(st2.nextToken());
        }

        V[0][0] = true;

        for (int j=0; j<N; j++)
        {
            for (int i=0; i<N; i++)
            {
                if ( V[i][j] == true )
                {
                    DP[i+1][j] = Math.max(DP[i+1][j], DP[i][j]);
                    V[i+1][j] = true;
                    
                    DP[i+1][j+1] = Math.max(DP[i+1][j+1], DP[i][j]);
                    V[i+1][j+1] = true;

                    if ( R[j] < L[i] )
                    {
                        DP[i][j+1] = Math.max( DP[i][j+1], DP[i][j] + R[j]);
                        max = Math.max(max, DP[i][j+1]);
                        V[i][j+1] = true;
                    }
                }
            }
        }

        output.write(max + "");
        output.close();
    }
}