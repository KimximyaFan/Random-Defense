import java.io.*;
import java.util.*;

public class C0034
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        StringBuilder S = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if ( N >= K )
        {
            output.write( N-K + "\n");

            for (int i=N; i>=K; i--)
                output.write(i + " ");
            
            output.close();

            return;
        }

        int[] isVisited = new int[100001];
        int[] parent = new int[100001];

        Arrays.fill(isVisited, -1);

        Queue<Integer> Q = new LinkedList<>();
        isVisited[N] = 0;
        Q.add(N);

        while ( !Q.isEmpty() )
        {
            N = Q.poll();

            if ( N == K )
                break;

            if ( N-1 >= 0 && isVisited[N-1] == -1 )
            {
                isVisited[N-1] = isVisited[N] + 1;
                parent[N-1] = N;
                Q.add(N-1);
            }

            if ( N+1 <= 100000 && isVisited[N+1] == -1 )
            {
                isVisited[N+1] = isVisited[N] + 1;
                parent[N+1] = N;
                Q.add(N+1);
            }

            if ( 2*N <= 100000 && isVisited[2*N] == -1 )
            {
                isVisited[2*N] = isVisited[N] + 1;
                parent[2*N] = N;
                Q.add(2*N);
            }
        }

        S.insert(0, N + " ");

        while ( isVisited[N] != 0 )
        {
            N = parent[N];
            S.insert( 0, N + " ");
        }

        output.write( isVisited[K] + "\n" );
        output.write( S.toString() );
        output.close();
    }
}