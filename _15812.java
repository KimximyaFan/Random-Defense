import java.io.*;
import java.util.*;

public class _15812
{
    static class Node
    {
        int x, y;
        Node (int x, int y) {this.x = x; this.y = y;}
    }

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int time = 500000;

        for (int i=0; i<N; i++)
        {
            String s = input.readLine();
            
            for (int j=0; j<M; j++)
                map[i][j] = s.charAt(j) - '0';
        }

        for (int i=0; i<N*M; i++)
        {
            if ( map[i/M][i%M] == 0 )
            {
                Node node_0 = new Node(i/M, i%M);

                for (int j=i+1; j<N*M; j++)
                {
                    if ( map[j/M][j%M] == 0 )
                    {
                        Node node_1 = new Node(j/M, j%M);
                        int elapsed_time = Bfs(map, Deep_Copy(map), N, M, node_0, node_1);

                        if ( elapsed_time < time )
                            time = elapsed_time;
                    }
                }
            }
        }

        System.out.print(time);
    }

    static int[][] Deep_Copy(int[][] map)
    {
        int[][] copied = new int[map.length][map[0].length];

        for (int i=0; i<map.length; i++)
        {
            for (int j=0; j<map[i].length; j++)
                copied[i][j] = map[i][j];
        }

        return copied;
    }

    static int Bfs (int[][] map, int[][] copied, int N, int M, Node node_0, Node node_1)
    {
        Queue<Node> Q = new LinkedList<>();
        Q.add(node_0);
        Q.add(node_1);
        copied[node_0.x][node_0.y] = -1;
        copied[node_1.x][node_1.y] = -1;

        while ( !Q.isEmpty() )
        {
            Node current_node = Q.poll();
            int current_time = copied[current_node.x][current_node.y];

            for (int i=0; i<4; i++)
            {
                int next_x = current_node.x + dx[i];
                int next_y = current_node.y + dy[i];

                if ( next_x < 0 || next_x >= N || next_y < 0 || next_y >= M
                || copied[next_x][next_y] < 0 )
                    continue;

                Q.add(new Node(next_x, next_y));
                copied[next_x][next_y] = current_time - 1;
            }
        }

        int max_value = 0;

        for (int i=0; i<N; i++)
        {
            for (int j=0; j<M; j++)
            {
                if ( map[i][j] == 1 && Math.abs(copied[i][j]) > max_value )
                    max_value = Math.abs(copied[i][j]);
            }
        }

        return max_value - 1;
    }
}