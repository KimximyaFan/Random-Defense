import java.io.*;
import java.util.*;

public class C0050
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
    static Edge[] A;

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(input.readLine());
        W = new int[N+1];
        DP = new int[N+1][2];
        A = new Edge[N+1];

        st = new StringTokenizer(input.readLine());

        for (int i=1; i<=N; i++)
            W[i] = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N-1; i++)
        {
            st = new StringTokenizer(input.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u] = new Edge(v, A[u]);
            A[v] = new Edge(u, A[v]);
        }

        dfs(1, -1);

        System.out.print(Math.max(DP[1][0], DP[1][1]));
    }

    static void dfs (int x, int p)
    {
        DP[x][0] = 0;
        DP[x][1] = W[x];

        for (Edge E = A[x]; E != null; E = E.next)
        {
            if ( E.v != p )
            {
                dfs(E.v, x);
                DP[x][0] += Math.max(DP[E.v][0], DP[E.v][1]);
                DP[x][1] += DP[E.v][0];
            }
        }
    }
}