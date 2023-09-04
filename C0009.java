import java.io.*;
import java.util.*;

public class C0009
{
    public static class pair
    {
        int x = 0;
        int y = 0;

        pair () {}
        pair (int a, int b) { this.x = a; this.y = b; }

        public int CrossProduct(pair o)
        {
            return this.x * o.y - this.y * o.x;
        }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] X = new int[3];
        int[] Y = new int[3];

        for (int i=0; i<3; i++)
        {
            st = new StringTokenizer(input.readLine());

            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }

        pair V1 = new pair (X[1]-X[0], Y[1]-Y[0]);
        pair V2 = new pair (X[2]-X[1], Y[2]-Y[1]);

        int a = V1.CrossProduct(V2);

        if ( a > 0 )
            output.write("1");
        else if ( a == 0 )
            output.write("0");
        else
            output.write("-1");
        
        output.close();
    }
}