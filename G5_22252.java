import java.io.*;
import java.util.*;

public class G5_22252
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int Q = Integer.parseInt(input.readLine());
        int query_type = 0;
        int count = 0;
        long sum = 0;
        String name;
        HashMap<String, PriorityQueue<Integer>> hm = new HashMap<>();
        PriorityQueue<Integer> current_queue;

        while ( Q-- > 0 )
        {
            st = new StringTokenizer(input.readLine());

            query_type = Integer.parseInt(st.nextToken());
            name = st.nextToken();

            if ( hm.containsKey(name) == false )
                hm.put(name, new PriorityQueue<>(Comparator.reverseOrder()));

            current_queue = hm.get(name);
            count = Integer.parseInt(st.nextToken());

            if ( query_type == 1 )
            {
                for (int i=0; i<count; i++)
                    current_queue.add(Integer.parseInt(st.nextToken()));
            }
            else
            {
                count = Math.min(count, current_queue.size());

                for (int i=0; i<count; i++)
                    sum += current_queue.poll();
            }
        }

        System.out.print(sum);
    }
}