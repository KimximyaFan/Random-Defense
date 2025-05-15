import java.io.*;
import java.util.*;

public class S4_2075
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(input.readLine());

            for (int j=0; j<N; j++) 
            {
                pq.add(Integer.parseInt(st.nextToken()));

                if ( pq.size() > N )
                    pq.poll();
            }
                
        }

        System.out.print(pq.peek());
    }
}