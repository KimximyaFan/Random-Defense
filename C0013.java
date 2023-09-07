import java.io.*;
import java.util.*;

public class C0013
{
    static int min, count;
    static int[] A, B, C;
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;

        int N = Integer.parseInt(input.readLine());
        min = Integer.MAX_VALUE;
        A = new int[N+2];
        B = new int[N+2];

        s = input.readLine();

        for (int i=1; i<=N; i++)
            A[i] = s.charAt(i-1) - 48;
        
        s = input.readLine();

        for (int i=1; i<=N; i++)
            B[i] = s.charAt(i-1) - 48;
        
        count = 0;

        C = Arrays.copyOf(A, N+2);

        for (int i=2; i<=N; i++)
        {
            if ( C[i-1] != B[i-1] )
                press(i);
            
            if ( i == N && C[i] == B[i] )
                min = Math.min(min, count);
        }

        count = 0;

        C = Arrays.copyOf(A, N+2);

        press(1);

        for (int i=2; i<=N; i++)
        {
            if ( C[i-1] != B[i-1] )
                press(i);
            
            if ( i == N && C[i] == B[i] )
                min = Math.min(min, count);
        }

        if ( min == Integer.MAX_VALUE )
            output.write("-1");
        else
            output.write(min + "");
        
        output.close();
    }

    static void press (int a)
    {
        count++;

        for (int i=a-1; i<=a+1; i++)
        {
            if ( C[i] == 0)
                C[i] = 1;
            else
                C[i] = 0;
        }
    }
}
