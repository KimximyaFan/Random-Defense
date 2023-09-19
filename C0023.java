import java.io.*;
import java.util.*;

public class C0023
{
    static int N;
    static long[] A;
    static boolean End = false;
    static boolean[] isVisited;
    static ArrayList<Long> X = new ArrayList<>();

    static BufferedReader input;
    static BufferedWriter output;

    public static void main (String[] args) throws IOException
    {
        input = new BufferedReader(new InputStreamReader(System.in));
        output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(input.readLine());

        A = new long[N];
        isVisited = new boolean[N];

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
            A[i] = Long.parseLong(st.nextToken());

        for (int i=0; i<N; i++)
        {
            dfs(i, 0);
            isVisited[i] = false;
            X.remove(X.size()-1);

            if (End == true)
                break;
        }

        output.close();
    }

    public static void dfs (int x, int depth) throws IOException
    {
        X.add( A[x] );
        isVisited[x] = true;
        depth++;

        if ( depth == N )
        {
            End = true;

            for (int i=0; i<X.size(); i++)
                output.write( X.get(i) + " ");

            return;
        }

        for (int i=0; i<N; i++)
        {
            if ( isVisited[i] == false && End == false )
            {
                long a = X.get(X.size()-1);

                if ( (a%3 == 0 && a/3 == A[i]) || ( 2*a == A[i])  )
                {
                    dfs(i, depth);
                    isVisited[i] = false;
                    X.remove(X.size()-1);
                }
            }
        }
    }
}
