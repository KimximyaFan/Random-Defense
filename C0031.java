import java.io.*;
import java.util.*;

public class C0031
{
    static int count;
    static boolean[] A;
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new boolean[N];

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
        {
            if ( Integer.parseInt(st.nextToken()) == 1 )
                A[i] = true;
        }

        count = Check();
        
        for (int i=0; i<M; i++)
        {
            st = new StringTokenizer(input.readLine());

            int a = Integer.parseInt(st.nextToken());

            if ( a == 0 )
                output.write( count + "\n");
            else
            {
                int b = Integer.parseInt(st.nextToken()) - 1;

                if ( A[b] == false )
                {
                    A[b] = true;
                    Check2(b);
                }
            }
        }

        output.close();
    }

    public static void Check2 (int i)
    {
        boolean isBack = false;
        boolean isFront = false;

        if ( i >= 1 && A[i-1] == true )
            isBack = true;

        if ( i < A.length-1 && A[i+1] == true)
            isFront = true;
        
        if ( isBack == true && isFront == true )
            count--;
        else if ( i == 0 )
        {
            if ( isFront == false )
                count++;
        }
        else if ( i == A.length-1 )
        {
            if ( isBack == false )
                count++;
        }
        else if ( isBack == false && isFront == false )
            count++;
    }

    public static int Check ()
    {
        int a = 0;
        boolean isConsecutive = false;

        for (int i=0; i<A.length; i++)
        {
            if ( A[i] == true && isConsecutive == false)
            {
                isConsecutive = true;
                a++;
            }
            else if ( A[i] == false )
                isConsecutive = false;
        }

        return a;
    }
}