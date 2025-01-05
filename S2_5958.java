import java.io.*;
import java.util.*;

public class S2_5958
{
    static class Pair
    {
        int x; int y;
        Pair(int x, int y) { this.x = x; this.y = y; }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(input.readLine());
        char[][] field = new char[N+2][N+2];
        int count = 0;

        for (int i=1; i<=N; i++)
        {
            String s = input.readLine();

            for (int j=1; j<=N; j++)
                field[i][j] = s.charAt(j-1);
        }

        for (int i=1; i<=N; i++)
        {
            for (int j=1; j<=N; j++)
            {
                if ( field[i][j] == '*' )
                {
                    Bfs(field, i, j);
                    count++;
                }
            }
        }

        System.out.print(count);
    }

    public static void Bfs (char[][] field, int x, int y)
    {
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        Queue<Pair> Q = new LinkedList<>();

        Q.add(new Pair(x, y));
        field[x][y] = '.';

        while (!Q.isEmpty())
        {
            Pair current_pos = Q.poll();

            for (int i=0; i<4; i++)
            {
                int next_x = current_pos.x + dx[i];
                int next_y = current_pos.y + dy[i];

                if ( field[next_x][next_y] == '*' )
                {
                    Q.add(new Pair(next_x, next_y));
                    field[next_x][next_y] = '.';
                }
            }
        }
    }
}