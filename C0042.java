import java.io.*;
import java.util.*;

public class C0042
{
    static int N;
    static int[][] DP;
    static node[] A;

    static class node
    {
        int v;
        node next;

        node (int v, node next) { this.v = v; this.next = next; }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(input.readLine());
        DP = new int[N+1][2];

        A = new node[N+1];
        
        for (int i=0; i<N-1; i++)
        {
            st = new StringTokenizer(input.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u] = new node(v, A[u]);
            A[v] = new node(u, A[v]);
        }

        dfs(1, -1);

        System.out.print(Math.min(DP[1][0], DP[1][1]));
    }

    static void dfs(int x, int p)
    {
        DP[x][0] = 0;
        DP[x][1] = 1;

        for (node T = A[x]; T != null; T = T.next)
        {
            if ( T.v != p )
            {
                dfs(T.v, x);
                DP[x][0] += DP[T.v][1];
                DP[x][1] += Math.min(DP[T.v][0], DP[T.v][1]);
            }
        }
    } 
}