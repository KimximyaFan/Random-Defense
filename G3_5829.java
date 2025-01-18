import java.io.*;
import java.util.*;

public class G3_5829
{
    static class Node
    {
        int left, right;
        Node (int l, int r) { left = l; right = r; }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());
        char[] direction = new char[M];
        int[] end_point = new int[N+1];
        ArrayList<Node> graph = new ArrayList<>();
        int[][] jump = new int[N+1][32];
        graph.add(new Node(0, 0));

        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(input.readLine());

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            graph.add(new Node(left, right));
        }
        
        st = new StringTokenizer(input.readLine());

        for (int i=0; i<M; i++)
            direction[i] = st.nextToken().charAt(0);

        for (int i=1; i<=N; i++)
        {
            int current_point = i;

            for (int j=0; j<M; j++)
            {
                if ( direction[j] == 'L' )
                    current_point = graph.get(current_point).left;
                else
                    current_point = graph.get(current_point).right;
            }

            end_point[i] = current_point;
            jump[i][0] = end_point[i];
        }

        for (int j=1; j<=31; j++)
        {
            for (int i=1; i<=N; i++)
                jump[i][j] = jump[jump[i][j-1]][j-1];
        }
        
        int current_point = 1;

        for (int i=0; i<=31; i++)
        {
            if ( ( (K>>i) & 1 ) == 1 )
                current_point = jump[current_point][i];
        }

        System.out.println(current_point);
    }
}