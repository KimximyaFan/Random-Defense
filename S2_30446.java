import java.io.*;
import java.util.*;

public class S2_30446
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(input.readLine());

        int place_count = Long.toString(N).length();

        ArrayList<String>[] palin_list = new ArrayList[11];

        for (int i=0; i<=10; i++)
            palin_list[i] = new ArrayList<>();

        palin_list[1].add("0");
        palin_list[2].add("00");

        for (int i=1; i<=9; i++) {
            palin_list[1].add( Integer.toString(i) );
            palin_list[2].add( Integer.toString( i * 11 ) );
        }

        int count = Math.min(place_count, 2);
        int ans = -count;

        while ( count < place_count )
        {
            count++;

            for (int i=0; i<=9; i++)
            {
                for (int j=0; j<palin_list[count-2].size(); j++)
                {
                    if ( i == 0 )
                        ans--;

                    palin_list[count].add( i + palin_list[count-2].get(j) + i );
                }
                    
            }
        }

        for (int i=1; i<=count-1; i++)
            ans += palin_list[i].size();

        for (int i=0; i<palin_list[count].size(); i++)
        {
            if ( Long.parseLong( palin_list[count].get(i) ) > N )
                break;
            
            ans++;
        }

        System.out.print(ans);
    }
}