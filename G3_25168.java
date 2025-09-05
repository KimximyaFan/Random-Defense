import java.io.*;
import java.util.*;

public class G3_25168
{
    static class Pair
    {
        int v, w;
        Pair (int v, int w) {this.v = v; this.w = w;}
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] degree = new int[N+1];
        ArrayList<Pair>[] G = new ArrayList[N+1];

        for (int i=1; i<=N; i++)
            G[i] = new ArrayList<>();

        for (int i=0; i<M; i++)
        {
            st = new StringTokenizer(input.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            G[u].add(new Pair(v, w));
            degree[v]++;
        }

        System.out.print(Topology_Sort(N, degree, G));
    }

    static int Topology_Sort(int N, int[] degree, ArrayList<Pair>[] G)
    {
        Queue<Integer> Q = new LinkedList<>();
        int[] day = new int[N+1];
        int ans = 1;

        for (int i=1; i<=N; i++)
        {
            if ( degree[i] == 0 )
            {
                Q.add( i );
                day[i] = 1;
            }
                
        }

        while ( !Q.isEmpty() )
        {
            int u = Q.poll();
            ans = Math.max(ans, day[u]);

            for (int i=0; i<G[u].size(); i++)
            {
                int v = G[u].get(i).v;
                int w = G[u].get(i).w <= 6 ? G[u].get(i).w : G[u].get(i).w + 1;

                degree[v]--;

                day[v] = Math.max(day[v], day[u] + w);

                if ( degree[v] == 0 )
                    Q.add( v );
            }
        }

        return ans;
    }
}