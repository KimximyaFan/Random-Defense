import java.io.*;
import java.util.*;

public class C0043
{
    static int N, ans;
    static boolean[] isEarly;
    static node[] A;

    static class node
    {
        int v;
        node next;

        node (int v, node next) { this.v = v; this.next = next; }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(input.readLine());
        isEarly = new boolean[N+1];

        A = new node[N+1];
        
        for (int i=0; i<N-1; i++)
        {
            st = new StringTokenizer(input.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u] = new node(v, A[u]);
            A[v] = new node(u, A[v]);
        }

        dfs(1, -1);

        System.out.println(ans);
    }

    static void dfs(int x, int p)
    {
        int size = 1;

        int count = 0;

        for (node T = A[x]; T != null; T = T.next)
        {
            if ( T.v != p )
            {
                dfs(T.v, x);
                size++;

                if ( isEarly[T.v] == true )
                    count++;

            }
        }

        if ( isEarly[x] == false && p != -1 )
        {
            if ( isEarly[p] == true )
            {
                count++;

                if ( size > count )
                {
                    isEarly[x] = true;
                    ans++;
                }
            }
            else
            {
                if ( size - count >= 2 )
                    isEarly[x] = true;
                else
                    isEarly[p] = true;

                ans++;
            }
        }
    } 
}