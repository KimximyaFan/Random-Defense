import java.io.*;
import java.util.*;

public class C0049
{
    static class Edge
    {
        int v;
        Edge next;
        Edge (int v, Edge e) { this.v = v; this.next = e; }
    }

    static int N;
    static int[] W;
    static int[][] DP;
    static Edge[] Node;
    static PriorityQueue<Integer> Q = new PriorityQueue<>();

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(input.readLine());
        W = new int[N+1];
        DP = new int[N+1][2];
        Node = new Edge[N+1];

        st = new StringTokenizer(input.readLine());

        for (int i=1; i<=N; i++)
            W[i] = Integer.parseInt(st.nextToken());
        
        for (int i=1; i<=N-1; i++)
        {
            st = new StringTokenizer(input.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Node[u] = new Edge(v, Node[u]);
            Node[v] = new Edge(u, Node[v]);
        }

        dfs(1, -1);
        dfs2(1, -1, true);
        
        S.append( Math.max( DP[1][0], DP[1][1]) + "\n" );

        while ( !Q.isEmpty() )
            S.append( Q.poll() ).append(" ");
        
        System.out.print(S);
    }

    static void dfs (int x, int p)
    {
        DP[x][0] = 0;
        DP[x][1] = W[x];

        for (Edge E = Node[x]; E != null; E = E.next)
        {
            if ( E.v != p )
            {
                dfs(E.v, x);
                DP[x][0] += Math.max( DP[E.v][0], DP[E.v][1] );
                DP[x][1] += DP[E.v][0];
            }
        }
    }

    static void dfs2 (int x, int p, boolean isPossible)
    {
        if ( isPossible == true && DP[x][1] > DP[x][0] )
        {
            Q.add(x);
            isPossible = false;
        }
        else
            isPossible = true;

        for (Edge E = Node[x]; E != null; E = E.next)
        {
            if ( E.v != p )
                dfs2( E.v, x, isPossible );
        }
    }
}