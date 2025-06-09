import java.io.*;
import java.util.*;

public class S2_9700
{
    static int[] dx = { 1, 1, 1, 0, 0, -1, -1, -1 };
    static int[] dy = { 1, 0, -1, 1, -1, 1, 0, -1 };
    static int case_count = 0;

    static class Pair
    {
        int x, y;
        Pair (int x, int y) { this.x = x; this.y = y; }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = "";

        while ( (s = input.readLine()) != null && !s.isEmpty() )
        {
            int N = Integer.parseInt(s);
            char[][] field = new char[N][N];
            
            case_count++;

            for (int i=0; i<N; i++)
            {
                s = input.readLine();

                for (int j=0; j<N; j++)
                    field[i][j] = s.charAt(j);
            }

            sb.append("Case #").append(case_count).append(": ").append( Search(field, N) ).append("\n");
        }

        System.out.print(sb);
    }

    static void BFS (char[][] field, int N, int x, int y)
    {
        Queue<Pair> Q = new LinkedList<>();
        field[x][y] = '0';
        Q.add(new Pair(x, y));

        while ( !Q.isEmpty() )
        {
            Pair current_pos = Q.poll();

            for (int i=0; i<8; i++)
            {
                int next_x = current_pos.x + dx[i];
                int next_y = current_pos.y + dy[i];

                if ( next_x < 0 || next_x >= N || next_y < 0 || next_y >= N || field[next_x][next_y] == '0' )
                    continue;

                field[next_x][next_y] = '0';
                Q.add(new Pair(next_x, next_y));
            }
        }
    }

    static int Search (char[][] field, int N)
    {
        int count = 0;

        for (int i=0; i<N; i++)
        {
            for (int j=0; j<N; j++)
            {
                if ( field[i][j] == '1' )
                {
                    BFS(field, N, i, j);
                    count++;
                }
            }
        }
                
        return count;
    }
}