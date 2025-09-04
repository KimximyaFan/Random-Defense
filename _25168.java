import java.io.*;
import java.util.*;

public class _25168
{
    static class Vaccine
    {
        int u, vaccine_day;
        Vaccine(int u, int vaccine_day) {this.u = u; this.vaccine_day = vaccine_day; }
    }

    static class Pair
    {
        int v, w;
        Pair (int v, int w) {this.v = v; this.w = w;}
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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
        Queue<Vaccine> Q = new LinkedList<>();
        int day = 1;

        for (int i=1; i<=N; i++)
        {
            if ( degree[i] == 0 )
                Q.add( new Vaccine(i, day) );
        }

        while ( !Q.isEmpty() )
        {
            Vaccine current_Vaccine = Q.poll();
            int u = current_Vaccine.u;
            int vaccine_day = current_Vaccine.vaccine_day;

            for (int i=0; i<G[u].size(); i++)
            {
                int v = G[u].get(i).v;
                int w = G[u].get(i).w >= 7 ? 8 : G[u].get(i).w;

                degree[v]--;

                day = Math.max(day, vaccine_day + w);

                if ( degree[v] == 0 )
                    Q.add( new Vaccine(v, day) );
            }
        }

        return day;
    }
}