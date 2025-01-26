import java.io.*;

public class S2_6092
{
    public static void main (String[] args) throws IOException
    {
        for (int i=1; i<=12; i++)
            System.out.println( Four_Tower(i) );
    }

    static int Three_Tower (int n)
    {
        return (int)(Math.pow(2, n) + 0.0001) - 1;
    }

    static int Four_Tower (int n)
    {
        if ( n <= 1 )
            return n;

        int min = 10000000;

        for (int k=1; k<=n; k++)
            min = Math.min ( min, 2 * Four_Tower(n-k) + Three_Tower(k) );

        return min;
    }
}