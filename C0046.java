import java.io.*;

public class C0046
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder();

        int T = Integer.parseInt(input.readLine());

        while (T-- > 0)
        {
            long N = Long.parseLong(input.readLine());

            while ( Prime(N) == false )
                N++;
            
            S.append(N + "\n");
        }
        
        System.out.print( S.toString() );
    }

    static boolean Prime (long X)
    {
        if ( X == 2 )
            return true;
        else if ( X <= 1 || X % 2 == 0 )
            return false;
        
        for (long i=3; i*i<=X; i=i+2)
        {
            if ( X % i == 0 )
                return false;
        }

        return true;
    } 
}