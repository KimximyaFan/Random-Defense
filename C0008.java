import java.io.*;
import java.util.*;

public class C0008
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        long[] A = new long[N];
        long B = 0;
        boolean isHappy = true;

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
        {
            A[i] = Long.parseLong(st.nextToken());
            B += A[i];
        }

        for (int i=0; i<N; i++)
        {
            if ( B/2 < A[i] ) 
            {
                isHappy = false;
                break;
            }
        }
        
        if ( N == 1 && A[0] == 1)
            isHappy = true;
        
        if ( isHappy == true )
            output.write("Happy");
        else
            output.write("Unhappy");

        output.close();
    }
}
