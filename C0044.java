import java.io.*;
import java.util.*;

public class C0044
{
    static int[] size;
    static Node[] A;

    static class Node
    {
        int v;
        Node next;
        Node (int v, Node node) { this.v = v; this.next = node; }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        size = new int[N+1];

        A = new Node[N+1];

        for (int i=0; i<N-1; i++)
        {
            st = new StringTokenizer(input.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u] = new Node(v, A[u]);
            A[v] = new Node(u, A[v]);
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
        size[x] = 1;

        for (Node node = A[x]; node != null; node = node.next)
        {
            if ( node.v != p )
            {
                makeTree(node.v, x);
                size[x] += size[node.v];
            }
        }
    }
}