import java.io.*;
import java.util.*;

public class C0017
{
    static int[] dx = { 0, -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 0, -1, 1 };
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];

        int K = Integer.parseInt(input.readLine());

        for (int i=0; i<K; i++)
        {
            st = new StringTokenizer(input.readLine());

            A[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        st = new StringTokenizer(input.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        ArrayList<Integer> C = new ArrayList<>();

        st = new StringTokenizer(input.readLine());

        boolean[] Direction = new boolean[5];

        while ( st.hasMoreTokens() )
        {
            C.add(Integer.parseInt(st.nextToken()));
            Direction[C.get(C.size()-1)] = true;
        }
            
        
        A[X][Y] = 1;

        int i = 0;

        while (true)
        {
            if ( i == C.size() )
                i = 0;

            int D = C.get(i);

            if ( X + dx[D] < 0 || X + dx[D] >= N || Y + dy[D] < 0 
            || Y + dy[D] >= M || A[X + dx[D]][Y + dy[D]] == 1)
            {
                boolean isPossible = false;
            
                for (int j=1; j<=4; j++)
                {
                    if ( Direction[j] == true)
                    {
                        if (  X + dx[j] < 0 || X + dx[j] >= N || Y + dy[j] < 0 
                        || Y + dy[j] >= M || A[X + dx[j]][Y + dy[j]] == 1)
                            continue;
                        
                        isPossible = true;
                    }
                }

                if ( isPossible == false )
                    break;

                i++;
                continue;
            }

            X += dx[D];
            Y += dy[D];

            A[X][Y] = 1;
        }

        output.write(X + " " + Y);
        output.close();
    }
}