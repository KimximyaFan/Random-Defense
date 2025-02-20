import java.io.*;
import java.util.*;

public class G3_27945
{
    static int[] parent;

    static class Edge implements Comparable<Edge>
    {
        int u, v, w;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }

        @Override
        public int compareTo(Edge o) 
        {
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
        int count = 0;
        parent = new int[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i=1; i<=N; i++)
            parent[i] = i;

        for (int i=0; i<M; i++)
        {
            st = new StringTokenizer(input.readLine());
            int u = Integer.parseInt( st.nextToken() );
            int v = Integer.parseInt( st.nextToken() );
            int day = Integer.parseInt(st.nextToken());

            pq.add( new Edge(u, v, day) );
        }

        while (true)
        {
            count++;
            Edge current_edge = pq.poll();
            int u = current_edge.u;
            int v = current_edge.v;
            int day = current_edge.w;

            if ( count != day || Union(u, v) == true )
                break;

            if ( count == N-1 )
            {
                count++;
                break;
            }
        }

        System.out.print(count);
    }

    static int Find (int p)
    {
        if ( parent[p] != p )
            parent[p] = Find(parent[p]);

        return parent[p];
    }

    static boolean Union (int u, int v)
    {
        int u_parent = Find(u);
        int v_parent = Find(v);

        if ( u_parent != v_parent )
        {
            parent[ Math.min(u_parent, v_parent) ] = Math.max(u_parent, v_parent);
            return false;
        }
            
        return true;
    }
}