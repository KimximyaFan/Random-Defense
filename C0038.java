import java.io.*;
import java.util.*;

public class C0038
{
    static int[] parent, size;
    static ArrayList<ArrayList<Integer>> A;
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        size = new int[N+1];

        A = new ArrayList<>();

        for (int i=0; i<=N; i++)
            A.add(new ArrayList<>());

        for (int i=0; i<N-1; i++)
        {
            st = new StringTokenizer(input.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A.get(u).add(v);
            A.get(v).add(u);
        }

        makeTree(R, -1);
        countSubtreeNodes(R);

        while (Q-- > 0)
        {
            int x = Integer.parseInt(input.readLine());
            output.write( size[x] + "\n" );
        }

        output.close();
    }

    static void makeTree(int x, int p)
    {
        parent[x] = p;

        for (int i=0; i<A.get(x).size(); i++)
        {
            if ( A.get(x).get(i) != p )
                makeTree(A.get(x).get(i), x);
        }
    }

    static void countSubtreeNodes(int x)
    {
        size[x] = 1;

        for (int i=0; i<A.get(x).size(); i++)
        {
            int v = A.get(x).get(i);

            if ( v != parent[x] )
            {
                countSubtreeNodes( v );
                size[x] += size[v];
            }
        }
    }
}