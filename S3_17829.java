import java.io.*;
import java.util.*;

public class S3_17829
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        int[][] pool = new int[N][N];

        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(input.readLine());

            for (int j=0; j<N; j++)
                pool[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.print(Recursive(pool, N));
    }

    static int Find_Second (int[][] pool, int x, int y)
    {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i=x; i<x+2; i++)
        {
            for (int j=y; j<y+2; j++)
            {
                if (pool[i][j] >= first)
                {
                    second = first;
                    first = pool[i][j];
                } 
                else if (pool[i][j] >= second && pool[i][j] < first)
                    second = pool[i][j];
            }
        }

        return second;
    }

    static int Recursive (int[][] pool, int size)
    {
        if ( size == 1 )
            return pool[0][0];

        int[][] new_pool = new int[size/2][size/2];

        for (int i=0; i<size/2; i++)
        {
            for (int j=0; j<size/2; j++)
                new_pool[i][j] = Find_Second(pool, i*2, j*2);
        }

        return Recursive(new_pool, size/2);
    }
}