import java.io.*;
import java.util.*;

public class C0035
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
      
        int T = Integer.parseInt(input.readLine());

        while (T-- > 0)
        {
            st = new StringTokenizer(input.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] parent = new int[10000];
            Arrays.fill(parent, -1);

            StringBuilder S = new StringBuilder();
            Queue<Integer> Q = new LinkedList<>();
            Q.add(A);
            parent[A] = 12345;

            while ( !Q.isEmpty() )
            {
                int X = Q.poll();

                if ( X == B )
                    break;

                if ( parent[ D(X) ] == -1 )
                {
                    parent[ D(X) ] = X;
                    Q.add(D(X));
                }

                if ( parent[ S(X) ] == -1 )
                {
                    parent[ S(X) ] = X;
                    Q.add(S(X));
                }

                if ( parent[ L(X) ] == -1 )
                {
                    parent[ L(X) ] = X;
                    Q.add(L(X));
                }

                if ( parent[ R(X) ] == -1 )
                {
                    parent[ R(X) ] = X;
                    Q.add(R(X));
                }
                
            }

            while ( parent[B] != 12345 )
            {
                if ( R(B) == parent[B] )
                    S.insert(0, 'L');
                else if ( L(B) == parent[B] )
                    S.insert(0, 'R');
                else if ( ((B+1) % 10000) == parent[B] )
                    S.insert(0, 'S');
                else
                    S.insert(0, 'D');

                B = parent[B];
            }

            output.write( S.toString() + "\n");
        }

        output.close();
    }

    public static int D (int X)
    {
        return (2*X) % 10000;
    }

    public static int S (int X)
    {
        return ((X-1) + 10000) % 10000;
    }

    public static int L (int X)
    {
        int a = X / 1000;
        int b = (X % 1000) / 100;
        int c = (X % 100) / 10;
        int d = X % 10;

        return b*1000 + c*100 + d*10 + a;
    }

    public static int R (int X)
    {
        int a = X / 1000;
        int b = (X % 1000) / 100;
        int c = (X % 100) / 10;
        int d = X % 10;

        return d*1000 + a*100 + b*10 + c;
    }
}