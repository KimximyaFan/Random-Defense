import java.io.*;

public class C0033
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        char[] A = input.readLine().toCharArray();
        char[] B = input.readLine().toCharArray();
        int[][] DP = new int[A.length + 1][B.length + 1];
        StringBuilder S = new StringBuilder();
        int x = A.length;
        int y = B.length;

        for (int i=1; i<=A.length; i++)
        {
            for (int j=1; j<=B.length; j++)
            {
                if ( A[i-1] == B[j-1] )
                    DP[i][j] = DP[i-1][j-1] + 1;
                else
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
            }
        }

        while (true)
        {
            if ( DP[x][y] == 0 )
                break;
            
            if ( DP[x-1][y] == DP[x][y] )
                x--;
            else if ( DP[x][y-1] == DP[x][y] )
                y--;
            else
            {
                S.append( A[x-1] );
                x--;
                y--;
            }
        }

        System.out.println( DP[A.length][B.length] );
        System.out.println( S.reverse().toString() );
    }
}