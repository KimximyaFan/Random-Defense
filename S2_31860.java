import java.io.*;
import java.util.*;

public class S2_31860
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int satisfaction = 0;
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<N; i++)
            pq.add(Integer.parseInt(input.readLine()));
        
        while ( !pq.isEmpty() )
        {
            int importance = pq.poll();

            satisfaction = satisfaction/2 + importance;
            sb.append(satisfaction).append("\n");
            importance-= M;
            count++;
            
            if ( importance > K )
                pq.add(importance);
        }

        System.out.println(count);
        System.out.print(sb);
    }
}