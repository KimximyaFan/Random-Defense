import java.io.*;
import java.util.*;

public class _practice
{
    
    static class Pair implements Comparable<Pair>
    {
        int u, v, w;
        Pair (int u, int v, int w) {this.u = u; this.v = v; this.w = w; }

        public int compareTo(Pair o)
        {
            return this.w - o.w;
        }
    }

    static int[] dijkstra (ArrayList<ArrayList<Pair>> graph, int N, int start, int INF)
    {
        int[] dist = new int[N+1];
        boolean[] is_visited = new boolean[N+1];
        PriorityQueue<Pair> Q = new PriorityQueue<>();
    
        for (int i=1; i<=N; i++)
            dist[i] = INF;

        dist[start] = 0;
        is_visited[start] = true;
        Q.add(new Pair(start, 0, 0));

        while ( !Q.isEmpty() )
        {
            Pair current = Q.poll();

            int u = current.u;

            for (int i=0; i<graph.get(u).size(); i++)
            {
                int v = graph.get(u).get(i).v;
                int w = graph.get(u).get(i).w;

                if ( is_visited[v] == true )
                    continue;

                if ( dist[u] + w < dist[v] )
                {
                    dist[v] = dist[u] + w;
                    Q.add(new Pair(v, 0, dist[v]));
                }
            }
        }

        return dist;
    }
}

