import java.io.*;
import java.util.*;

public class C0012
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        int min = Integer.MAX_VALUE;
        int[] A = new int[N+1];

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        if ( N >= 3 )
        {
            for (int i=-1; i<=1; i++)
            {
                for (int j=-1; j<=1; j++)
                {
                    int A0 = A[0];
                    int A1 = A[1];
                    int d = 0;
                    int count = 0;
                    boolean isPossible = true;

                    if ( i != 0 )
                        count++;

                    if ( j != 0 )
                        count++;
                    
                    A0 += i;
                    A1 += j;

                    d = A1 - A0;

                    for (int k=2; k<N; k++)
                    {
                        int temp = Math.abs( (A0 + k*d) - A[k]);

                        if ( temp > 1)
                        {
                            isPossible = false;
                            break;
                        }
                        else if ( temp == 1 )
                            count++;
                    }

                    if ( isPossible )
                        min = Math.min(min, count);
                }
            }
        }
        else
            min = 0;
        
        if ( min == Integer.MAX_VALUE )
            output.write("-1");
        else
            output.write(min + "");
        output.close();
    }
}
