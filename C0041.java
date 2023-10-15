import java.io.*;
import java.util.*;

public class C0041
{
    static int N, ans;
    static boolean[] isEarly;
    static ArrayList<Integer>[] A;

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(input.readLine());
        isEarly = new boolean[N+1];

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

        dfs(1, -1);

        System.out.println(ans);
    }

    static void dfs(int x, int p)
    {
        int size = 1;

        int count = 0;

        for (int i=0; i<A[x].size(); i++)
        {
            int v = A[x].get(i);

            if ( v != p )
            {
                dfs(v, x);
                size++;

                if ( isEarly[v] == true )
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