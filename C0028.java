import java.io.*;
import java.util.*;

public class C0028
{
    static int N, M, idLength, count, X, Y;
    static String ID;
    static int[] check, require, currentRequire;
    static char[][] A;
    static Queue<Character> Bag;
    static StringBuilder sb = new StringBuilder();

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        idLength = Integer.parseInt(st.nextToken());
        check = new int[26];
        require = new int[26];
        A = new char[N+2][M+2];

        for (int i=1; i<=N; i++)
        {
            String s = input.readLine();

            for (int j=1; j<=M; j++)
            {
                char x = s.charAt(j-1);
                A[i][j] = x;
                check[ C2I(x) ]++;
            }
        }

        ID = input.readLine();
        ID_Check_Init();
        current_Require_Init();
        Bag_Init();
        X = 1; Y = 1;

        while (true)
        {
            boolean isOver = false;

            if ( isPossible() == false )
            {
                Move(N, M);
                break;
            }

            for (int i=1; i<=N; i++)
            {
                for (int j=1; j<=M; j++)
                {
                    if ( Bag.peek() == A[i][j] )
                    {
                        Move(i, j);

                        sb.append('P');

                        check[ C2I(A[i][j]) ]--;
                        currentRequire[ C2I(A[i][j]) ]--;
                        Bag.poll();

                        A[i][j] = 0;

                        if ( Bag.size() == 0 )
                        {
                            count++;

                            current_Require_Init();
                            Bag_Init();
                        }

                        isOver = true;
                        break;
                    }
                }

                if ( isOver == true )
                    break;
            }
        }

        output.write( count + " " + sb.length() +"\n");
        output.write(sb.toString());
        output.close();
    }

    public static int C2I (char x)
    {
        return (int)x - 97;
    }

    public static void ID_Check_Init ()
    {
        for (int i=0; i<ID.length(); i++)
            require[ C2I( ID.charAt(i) ) ]++;
    }

    public static void current_Require_Init ()
    {
        currentRequire = Arrays.copyOf(require, require.length);
    }

    public static boolean isPossible ()
    {
        boolean isPossible = true;

        for (int i=0; i<=25; i++)
        {
            if ( check[i] < currentRequire[i] )
            {
                isPossible = false;
                break;
            }
        }

        return isPossible;
    }

    public static void Bag_Init()
    {
        Bag = new LinkedList<>();

        for (int i=0; i<ID.length(); i++)
            Bag.add(ID.charAt(i));
    }

    public static void Move(int i, int j)
    {
        int dx = i - X;
        int dy = j - Y;

        X = i;
        Y = j;

        if ( dx > 0 )
        {
            for (int k=0; k<dx; k++)
                sb.append('D');
        }
        else if ( dx < 0 )
        {
            for (int k=0; k<-dx; k++)
                sb.append('U');
        }

        if ( dy > 0 )
        {
            for (int k=0; k<dy; k++)
                sb.append('R');
        }
        else if ( dy < 0 )
        {
            for (int k=0; k<-dy; k++)
                sb.append('L');
        }
    }
}