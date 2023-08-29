import java.io.*;
import java.util.*;

public class C0003 
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] DP = new int[K+1][N+1];
        int[] V = new int[K+1];
        int[] T = new int[K+1];

        for (int i=1; i<=K; i++)
        {
            st = new StringTokenizer(input.readLine());

            V[i] = Integer.parseInt(st.nextToken()); // 중요도
            T[i] = Integer.parseInt(st.nextToken()); // 시간
        }
               
        for (int i=1; i<=K; i++)
        {
            for (int j=1; j<=N; j++)
            {
                if ( j >= T[i] )
                    DP[i][j] = Math.max( DP[i-1][j - T[i]] + V[i], DP[i-1][j] );
                else
                    DP[i][j] = DP[i-1][j];
            }
        }

        output.write(DP[K][N] + "");
        output.close();
    }
}
