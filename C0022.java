import java.io.*;
import java.util.*;

public class C0022
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] K = new int[N+1];
        int[] S = new int[N+1];

        for (int i=1; i<=N; i++)
        {
            st = new StringTokenizer(input.readLine());

            K[i] = Integer.parseInt(st.nextToken());
            S[i] = Integer.parseInt(st.nextToken());
        }

        int[][] DP = new int[N+1][T+1];

        for (int i=1; i<=N; i++)
        {
            for (int j=1; j<=T; j++)
            {
                if ( j >= K[i] )
                    DP[i][j] = Math.max( DP[i-1][j], S[i] + DP[i-1][ j - K[i] ]);
                else
                    DP[i][j] = DP[i-1][j];
            }
        }

        output.write( DP[N][T] + "");
        output.close();
    }
}