import java.io.*;
import java.util.*;

public class G2_2696
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(input.readLine());

        while (T-- > 0)
        {
            int N = Integer.parseInt(input.readLine());
            ArrayList<Integer> num = new ArrayList<>();
            ArrayList<Integer> mid_history = new ArrayList<>();
            int read_count = N/10 + 1;

            for (int i=0; i<read_count; i++)
            {
                st = new StringTokenizer(input.readLine());

                while ( st.hasMoreTokens() )
                    num.add(Integer.parseInt(st.nextToken()));
            }
            
            PriorityQueue<Integer> under_max_heap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> over_min_heap = new PriorityQueue<>();
            int mid;
            
            over_min_heap.add(num.get(0));
            mid_history.add(over_min_heap.peek());

            if ( num.size() <= 2 )
            {
                sb.append(1).append("\n");
                sb.append(mid_history.get(0)).append("\n");
                continue;
            }

            over_min_heap.add(num.get(1));
            over_min_heap.add(num.get(2));

            under_max_heap.add( over_min_heap.poll() );
            mid = over_min_heap.poll();

            mid_history.add(mid);

            for (int i=3; i<num.size(); i++)
            {
                int current_num = num.get(i);

                if ( under_max_heap.size() == over_min_heap.size() )
                {
                    if ( current_num <= mid )
                    {
                        over_min_heap.add(mid);
                        
                        if ( current_num >= under_max_heap.peek() )
                            mid = current_num;
                        else
                        {
                            mid = under_max_heap.poll();
                            under_max_heap.add(current_num);
                        }
                    }
                    else
                        over_min_heap.add(current_num);
                }
                else
                {
                    if ( current_num <= mid )
                    {
                        under_max_heap.add(current_num);
                    }
                    else if ( current_num <= over_min_heap.peek() )
                    {
                        under_max_heap.add(mid);
                        mid = current_num;
                    }
                    else
                    {
                        over_min_heap.add(current_num);
                        under_max_heap.add(mid);
                        mid = over_min_heap.poll();
                    }

                    mid_history.add(mid);
                }
            }

            sb.append(mid_history.size()).append("\n");

            for (int i=0; i<mid_history.size(); i++)
            {
                if ( i % 10 == 0 && i != 0 )
                    sb.append("\n");

                sb.append(mid_history.get(i)).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}