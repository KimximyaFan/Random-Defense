import java.io.*;
import java.util.*;

public class S1_1303
{
    static class Pair
    {
        int x, y;
        Pair (int x, int y) { this.x = x; this.y = y; }
    }

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] field = new char[M+2][N+2];
        int w_power = 0;
        int b_power = 0;
        
        for (int i=1; i<=M; i++)
        {
            String s = input.readLine();

            for (int j=1; j<=N; j++)
                field[i][j] = s.charAt(j-1);
        }

        for (int i=1; i<=M; i++)
        {
            for (int j=1; j<=N; j++)
            {
                if ( field[i][j] == '0' )
                    continue;

                if ( field[i][j] == 'W')
                    w_power += BFS(field, N, M, i, j);
                else
                    b_power += BFS(field, N, M, i, j);

            }
        }

        System.out.print(w_power + " " + b_power);
    }

    static int BFS(char[][] field, int N, int M, int x, int y)
    {
        char standard = field[x][y];
        Queue<Pair> queue = new LinkedList<>();
        int count = 1;

        queue.add(new Pair(x, y));
        field[x][y] = '0';

        while ( !queue.isEmpty() )
        {
            Pair pos = queue.poll();

            for (int i=0; i<4; i++)
            {
                int next_x = pos.x + dx[i];
                int next_y = pos.y + dy[i];

                if ( next_x < 1 || next_x > M || next_y < 1 || next_y > N || field[next_x][next_y] == '0' || field[next_x][next_y] != standard )
                    continue;

                field[next_x][next_y] = '0';
                queue.add(new Pair(next_x, next_y));
                count++;
            }
        }

        return count*count;
    }
}