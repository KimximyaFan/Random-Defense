import java.io.*;
import java.util.*;

public class S3_4411
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while ( true )
        {
            int N = Integer.parseInt(input.readLine());
            int avg = 0;

            if ( N == 0 ) break;

            int[] expense = new int[N];
            
            for (int i=0; i<N; i++)
            {
                String in = input.readLine();
                int dollar = Integer.parseInt( in.substring(0, in.length()-3) ) * 100;
                int cent = Integer.parseInt(in.substring(in.length()-2, in.length()));

                expense[i] = dollar + cent;

                avg += expense[i];
            }

            int over = 0;
            int under = 0;
            
            for (int i=0; i<N; i++)
            {
                int diff = expense[i]*N - avg;

                if ( diff > 0 )
                    over += diff/N;
                else
                    under += -diff/N;
            }

            int value = Math.max(over, under);

            sb.append( String.format("$%d.%02d\n", value/100, value%100) );
        }

        System.out.print(sb);
    }
}