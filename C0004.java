import java.io.*;
import java.util.*;

public class C0004
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int min = 10001;
        int L = 0;
        int R = L + K - 1;
        int[] A = new int[N];
        int[] Array = new int[K+1];
        int[] Array2 = new int[K+1];

        for (int i=0; i<N; i++)
        {
            int a = Integer.parseInt(input.readLine());
            Array2[a]++;
            A[i] = a;
        }

        for (int i=L; i<=R; i++)
        {
            Array[A[i]]++;
            Array2[A[i]]--;
        }

        while ( L < N && R < N )
        {
            if ( check(Array) == true )
            {
                if ( check(Array2) == true )
                    min = Math.min(min, R-L+1);

                Array[A[L]]--;
                Array2[A[L]]++;

                L++;
            }
            else
            {
                R++;

                if (R < N)
                {
                    Array[A[R]]++;
                    Array2[A[R]]--;
                }
            }
        }
           
        if ( min == 10001 )
            output.write("0");
        else
            output.write(min + "");

        output.close();
    }

    public static boolean check (int[] A)
    {
        for (int i=1; i<A.length; i++)
        {
            if ( A[i] == 0 )
                return false;
        }

        return true;
    }
}
