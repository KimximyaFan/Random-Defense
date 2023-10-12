import java.io.*;
import java.util.*;

public class C0039
{
    static int[] parent, size;
    static ArrayList<Integer>[] A;
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        size = new int[N+1];

        A = new ArrayList[N+1];

        for (int i=1; i<=N; i++)
            A[i] = new ArrayList<>();

        for (int i=0; i<N-1; i++)
        {
            st = new StringTokenizer(input.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u].add(v);
            A[v].add(u);
        }

        makeTree(R, -1);

        while (Q-- > 0)
        {
            int x = Integer.parseInt(input.readLine());
            S.append( size[x] + "\n" );
        }

        System.out.print( S.toString() );
    }

    static void makeTree(int x, int p)
    {
        parent[x] = p;
        size[x] = 1;

        for (int i=0; i<A[x].size(); i++)
        {
            int v = A[x].get(i);

            if ( v != p )
            {
                makeTree(v, x);
                size[x] += size[v];
            }
        }
    }
}