import java.io.*;
import java.util.*;

public class _practice
{
    
    public static void main (String[] args)
    {
        ArrayList<Integer> prime = Eratostenes(100);

        for (int i=0; i<prime.size(); i++)
            System.out.println(prime.get(i));
    }

    static class Node implements Comparable<Node>
    {
        int u, v, w;
        Node (int u, int v, int w) {this.u = u; this.v = v; this.w = w; }

        public int compareTo(Node o)
        {
            return this.w - o.w;
        }
    }

    static int[] dijkstra (ArrayList<ArrayList<Node>> graph, int N, int start, int INF)
    {
        int[] dist = new int[N+1];
        boolean[] is_visited = new boolean[N+1];
        PriorityQueue<Node> Q = new PriorityQueue<>();
    
        for (int i=1; i<=N; i++)
            dist[i] = INF;

        dist[start] = 0;
        Q.add(new Node(start, 0, 0));

        while ( !Q.isEmpty() )
        {
            Node current = Q.poll();

            int u = current.u;

            if ( is_visited[u] == true )
                continue;

            is_visited[u] = true;

            for (int i=0; i<graph.get(u).size(); i++)
            {
                int v = graph.get(u).get(i).v;
                int w = graph.get(u).get(i).w;

                if ( dist[u] + w < dist[v] )
                {
                    dist[v] = dist[u] + w;
                    Q.add(new Node(v, 0, dist[v]));
                }
            }
        }

        return dist;
    }

    static class Edge implements Comparable<Edge>
    {
        int u, v, w;
        Edge (int u, int v, int w) { this.u = u; this.v = v; this.w = w; }

        public int compareTo (Edge o)
        {
            return this.w - o.w;
        }
    }

    static int Find (int[] parent, int p)
    {
        if ( parent[p] != p )
            parent[p] = Find(parent, parent[p]);

        return parent[p];
    }

    static boolean Union (int[] parent, int x, int y)
    {
        int x_parent = Find(parent, x);
        int y_parent = Find(parent, y);

        if ( x_parent == y_parent )
            return true;

        parent[Math.min(x_parent,y_parent)] = Math.max(x_parent, y_parent);
        return false;
    }

    static int MST (PriorityQueue<Edge> pq, int N)
    {
        int[] parent = new int[N+1];
        int count = 0;
        int weight_sum = 0;

        for (int i=1; i<=N; i++)
            parent[i] = i;

        while ( !pq.isEmpty() )
        {
            Edge edge = pq.poll();
            int u = edge.u;
            int v = edge.v;
            int w = edge.w;

            if ( Union(parent, u, v) == false )
            {
                count++;
                weight_sum += w;
            }

            if ( count == N-1 )
                break;
        }

        return weight_sum;
    }

    static Queue<Integer> Topology_Sort (ArrayList<ArrayList<Node>> graph, int[] degree, int N)
    {
        Queue<Integer> Q = new LinkedList<>();
        Queue<Integer> return_Q = new LinkedList<>();

        for (int i=1; i<=N; i++)
        {
            if ( degree[i] == 0 )
                Q.add(i);
        }

        while ( !Q.isEmpty() )
        {
            int u = Q.poll();
            return_Q.add(u);

            for (int i=0; i<graph.get(u).size(); i++)
            {
                int v = graph.get(u).get(i).v;
                degree[v]--;
                
                if ( degree[v] == 0 )
                    Q.add(v);
            }
        }

        return return_Q;
    }

    static int GCD (int a, int b)
    {
        int temp, r;

        if ( b > a )
        {
            temp = a;
            a = b;
            b = temp;
        }

        while ( b != 0 )
        {
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    static int LCM (int a, int b)
    {
        return a*b / GCD(a, b);
    }

    static int nCr (int n, int r)
    {
        if ( r > n )
            return -1;

        if ( n == r || r == 0 )
            return 1;

        r = Math.min(r, n-r);

        long result = 1;

        for (int i=0; i<r; i++)
        {
            result *= n-i;
            result /= i+1;
        }

        return (int)result;
    }

    static int nPr (int n, int r)
    {
        long result = 1;

        for (int i=0; i<r; i++)
            result *= n-i;

        return (int)result;
    }

    static int[][] Floyd_Warshall (int[][] dist, int N, int INF)
    {
        int[][] G = new int[N+1][N+1];

        for (int i=1;i<=N; i++)
            for (int j=1; j<=N; j++)
                G[i][j] = i != j && dist[i][j] == 0 ? INF : dist[i][j];

        for (int k=1; k<=N; k++)
            for (int i=1; i<=N; i++)
                for (int j=1; j<=N; j++)
                    G[i][j] = Math.min( G[i][j], G[i][k] + G[k][j] );

        return G;
    }

    static int Power (int a, int b)
    {
        if ( b == 1 ) return a;
        int v = Power(a, b/2);
        return b % 2 == 0 ? v*v : v*v*a;
    }

    static ArrayList<Integer> Eratostenes (int N)
    {
        ArrayList<Integer> prime = new ArrayList<>();
        boolean[] flag = new boolean[N+1];

        for (int i=2; i*i<=N; i++)
        {
            if ( flag[i] == true )
                continue;

            for (int j=i*i; j<=N; j+=i)
                flag[j] = true;
        }

        for (int i=2; i<=N; i++)
        {
            if ( flag[i] == false )
                prime.add(i);
        }

        return prime;
    }

    static int[] Bellman_Ford (ArrayList<Edge> edges, int N, int start, int INF)
    {
        int[] dist = new int[N+1];
        boolean is_cycle = false;

        for (int i=1; i<=N; i++)
            dist[i] = INF;

        dist[start] = 0;

        for (int i=1; i<=N; i++)
        {
            for (Edge edge : edges)
            {
                int u = edge.u;
                int v = edge.v;
                int w = edge.w;

                if ( dist[u] != INF && dist[u] + w < dist[v] )
                {
                    dist[v] = dist[u] + w;

                    if ( i == N )
                    {
                        is_cycle = true;
                        break;
                    }
                }
            }
        }

        if ( is_cycle )
            dist[start] = -INF;

        return dist;
    }
}

