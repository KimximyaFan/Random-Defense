import java.io.*;
import java.util.*;

public class C0021
{
    static int N;
    static int[][] A;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] F = { {0, 0, 0}, {0, 1, 0}, {0, 0, 1}, {0, 1, 2}, {0, 1, 3, 0} };
    
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = 0;

        while ( (N = Integer.parseInt(new StringTokenizer(input.readLine()).nextToken())) != 0 )
        {
            count++;
            int max = Integer.MIN_VALUE;
            A = new int[N][N];

            for (int i=0; i<N; i++)
            {
                st = new StringTokenizer(input.readLine(), "  ");

                for (int j=0; j<N; j++)
                    A[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int i=0; i<N; i++)
            {
                for (int j=0; j<N; j++)
                {
                    for (int k=0; k<=3; k++)
                        max = Math.max(max, f(i, j, k));
                }
            }

            output.write( count + ". " + max + "\n");
        }

        output.close();
    }

    public static int f (int x, int y, int z)
    {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        boolean isPossible = true;

        for (int i=0; i<5; i++)
        {
            isPossible = true;
            int X = x;
            int Y = y;
            sum = 0;
            sum += A[X][Y];
            
            for (int j=0; j<F[i].length; j++)
            {
                if ( X+dx[ (F[i][j] + z)%4 ] < 0 || X+dx[ (F[i][j] + z)%4 ] > N-1 ||
                Y+dy[ (F[i][j] + z)%4 ] < 0 || Y+dy[ (F[i][j] + z)%4 ] > N-1)
                {
                    isPossible = false;
                    break;
                }
                
                X += dx[ (F[i][j] + z)%4 ];
                Y += dy[ (F[i][j] + z)%4 ];

                if ( F[i][j] != 3 )
                    sum += A[X][Y];
            }
            
            if ( isPossible == true)
                max = Math.max(max, sum);
        }

        return max;
    }
}