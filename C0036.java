import java.io.*;
import java.util.*;

public class C0036
{
    static class pair implements Comparable<pair>
    {
        int v = 0, w = 0;
        pair () {}
        pair (int v, int w) { this.v = v; this.w = w; }

        public int compareTo(pair o)
        {
            return this.w - o.w;
        }
    }
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N, M, start, end, MAX = 1000000001;
        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());
        ArrayList<pair>[] A = new ArrayList[N+1];
        boolean[] isVisited = new boolean[N+1];
        int[] dist = new int[N+1];
        int[] parent = new int[N+1];
        Arrays.fill(dist, MAX);
        PriorityQueue<pair> PQ = new PriorityQueue<>();
        StringBuilder S = new StringBuilder();
        

        for (int i=1; i<=N; i++)
            A[i] = new ArrayList<>();

        for (int i=0; i<M; i++)
        {
            st = new StringTokenizer(input.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A[u].add(new pair(v, w));
        }

        st = new StringTokenizer(input.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        dist[start] = 0;
        PQ.add( new pair(start, 0) );

        while ( !PQ.isEmpty() )
        {
            int u = PQ.poll().v;

            if ( isVisited[u] == true )
                continue;
            
            isVisited[u] = true;
            
            for (int i=0; i<A[u].size(); i++)
            {
                int v = A[u].get(i).v;
                int w = A[u].get(i).w;

                if ( dist[u] + w < dist[v] )
                {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                    PQ.add(new pair(v, dist[v]));
                }
            }
        }

        int x = end;
        int count = 0;

        while ( parent[x] != 0 )
        {
            S.insert(0, x + " ");
            count++;
            x = parent[x];
        }

        S.insert(0, x + " ");
        count++;

        output.write( dist[end] + "\n");
        output.write( count + "\n" );
        output.write( S.toString() );
        output.close();
    }
}
