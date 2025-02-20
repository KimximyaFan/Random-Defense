import java.io.*;
import java.util.*;

public class G3_17270
{
    static class Pair implements Comparable<Pair>
    {
        int v, w;

        Pair () {}
        Pair (int v, int w) { this.v = v; this.w = w; }

        public int compareTo(Pair o) {
            return this.w - o.w;
        }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int INF = 100000000;

        ArrayList<Pair>[] G = new ArrayList[N+1];

        for (int i=1; i<=N; i++)
            G[i] = new ArrayList<>();

        for (int i=0; i<M; i++)
        {
            st = new StringTokenizer(input.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            G[u].add( new Pair(v, w) );
            G[v].add( new Pair(u, w) );
        }

        st = new StringTokenizer(input.readLine());

        int ji_hun = Integer.parseInt(st.nextToken());
        int sung_ha = Integer.parseInt(st.nextToken());
        int[] ji_hun_list = Dijkstra(G, N, ji_hun, INF);
        int[] sung_ha_list = Dijkstra(G, N, sung_ha, INF);
        int min_dist_sum = INF;
        int min_node = -1;
        ArrayList<Integer> node_candidate = new ArrayList<>();

        for (int i=1; i<=N; i++)
        {
            int ji_hun_dist = ji_hun_list[i];
            int sung_ha_dist = sung_ha_list[i];
            int dist_sum = ji_hun_dist + sung_ha_dist;

            if ( i == ji_hun || i == sung_ha )
                continue;

            if ( dist_sum < min_dist_sum )
                min_dist_sum = dist_sum;
        }

        int min_ji_hun_dist = INF;

        for (int i=1; i<=N; i++)
        {
            int ji_hun_dist = ji_hun_list[i];
            int sung_ha_dist = sung_ha_list[i];
            int dist_sum = ji_hun_dist + sung_ha_dist;
            
            if ( i == ji_hun || i == sung_ha )
                continue;

            if ( dist_sum == min_dist_sum )
                node_candidate.add(i);
        }

        for (int i=0; i<node_candidate.size(); i++)
        {
            int node = node_candidate.get(i);
            int ji_hun_dist = ji_hun_list[node];
            int sung_ha_dist = sung_ha_list[node];

            if ( ji_hun_dist > sung_ha_dist )
                continue;

            if ( ji_hun_dist < min_ji_hun_dist )
            {
                min_node = node;
                min_ji_hun_dist = ji_hun_dist;
            }
        }

        System.out.print(min_node);
    }

    static int[] Dijkstra (ArrayList<Pair>[] G, int N, int start, int INF)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N+1];
        int[] dist = new int[N+1];

        for (int i=1; i<=N; i++)
            dist[i] = INF;

        dist[start] = 0;
        pq.add( new Pair(start, 0) );

        while ( !pq.isEmpty() )
        {
            int u = pq.poll().v;

            if ( isVisited[u] == true )
                continue;

            isVisited[u] = true;

            for (int i=0; i<G[u].size(); i++)
            {
                int v = G[u].get(i).v;
                int w = G[u].get(i).w;

                if ( dist[u] + w < dist[v] )
                {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}