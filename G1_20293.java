import java.io.*;
import java.util.*;

public class G1_20293
{
    static class Node
    {
        int x, y, fuel;
        Node (int x, int y, int fuel) { this.x = x; this.y = y; this.fuel = fuel; }
    }

    static int min_value;

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int R, C, N;
        int left, right, mid, max_fuel;

        st = new StringTokenizer(input.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(input.readLine());

        max_fuel = R+C-2;

        ArrayList<Node> node_list = new ArrayList<>();

        node_list.add( new Node(1, 1, 0) );
        node_list.add( new Node(R, C, 0) );
        
        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(input.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int fuel = Integer.parseInt(st.nextToken());

            node_list.add( new Node(x, y, fuel) );
        }

        Collections.sort(node_list, (a,b)->{
            if (a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        });

        left = 0;
        right = max_fuel;

        while ( left < right )
        {
            mid = (left + right) / 2;

            if ( Check_Possible(node_list, mid) == true )
                right = mid;
            else
                left = mid + 1;
        }

        System.out.print(left);
    }

    static int Dist(Node a, Node b)
    {
        return (b.y - a.y) + (b.x - a.x);
    }

    static boolean Check_Possible (ArrayList<Node> node_list, int start_fuel)
    {
        int N = node_list.size();
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);

        dp[0] = start_fuel;

        for (int i=1; i<N; i++)
        {
            Node dest_node = node_list.get(i);

            for (int j=0; j<i; j++)
            {
                Node start_node = node_list.get(j);

                if ( start_node.x <= dest_node.x && start_node.y <= dest_node.y && dp[j] >= Dist(start_node, dest_node) )
                    dp[i] = Math.max(dp[i], dp[j] - Dist(start_node, dest_node) + dest_node.fuel );
            }
        }

        return dp[N-1] >= 0;
    }
} 