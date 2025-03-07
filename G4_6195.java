import java.io.*;
import java.util.*;

public class G4_6195
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(input.readLine());
        long ans = 0;

        for (int i=0; i<N; i++)
            pq.add( Integer.parseInt(input.readLine()) );

        if ( N == 1 )
            ans += pq.poll();

        while ( pq.size() >= 2 )
        {
            int current_sum = pq.poll() + pq.poll();
            ans += current_sum;
            pq.add( current_sum );
        }

        System.out.print(ans);
    }
}