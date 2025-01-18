import java.io.*;
import java.util.*;

public class S2_3199
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken()) + b;
        double d = Double.parseDouble(st.nextToken()) + c;

        if ( Math.abs(b + c - d) < 0.0001 )
            System.out.printf("%.4f", 2 * b*c);
        else
            System.out.print(0);
    }
}