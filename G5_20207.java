import java.io.*;
import java.util.*;

public class G5_20207
{
    static class Task implements Comparable<Task>
    {
        int day_start, day_end, width, height;

        Task (int start, int end) 
        { 
            this.day_start = start; 
            this.day_end = end; 
            this.width = day_end - day_start; 
        }

        public int compareTo (Task o)
        {
            if ( this.day_start == o.day_start )
                return o.width - this.width;

            return this.day_start - o.day_start;
        }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());

        PriorityQueue<Task> tasks = new PriorityQueue<>();
        ArrayList< ArrayList<Task> > registered_task = new ArrayList<>();
        ArrayList<Task> registered = new ArrayList<>();

        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tasks.add( new Task(start, end) );
        }
         
        while ( !tasks.isEmpty() )
        {
            Task current_task = tasks.poll();
            int height = 0;

            while ( true )
            {
                if ( registered_task.size()-1 < height )
                    registered_task.add( new ArrayList<>() );

                ArrayList<Task> current_height_registered_task = registered_task.get(height);
                boolean flag = true;

                for (int i=0; i<current_height_registered_task.size(); i++)
                {
                    Task existing_task = current_height_registered_task.get(i);

                    if ( existing_task.day_end >= current_task.day_start )
                    {
                        height++;
                        flag = false;
                        break;
                    }
                }

                if ( flag == true )
                    break;
            }

            current_task.height = height;
            registered_task.get(height).add(current_task);
            registered.add(current_task);
        }
        
        Task first_task = registered.get(0);
        Task current_task;
        Task next_task;
        int ans = 0;
        int max_width = first_task.day_end - first_task.day_start + 1;
        int max_height = 0;

        for (int i=0; i<registered.size(); i++)
        {
            current_task = registered.get(i);

            if ( i == registered.size()-1 )
            {
                ans += max_width * (max_height + 1);
                break;
            }

            next_task = registered.get(i+1);

            if ( first_task.day_start + max_width < next_task.day_start )
            {
                ans += max_width * (max_height + 1);

                max_width = next_task.day_end - next_task.day_start + 1;
                max_height = next_task.height;
                first_task = next_task;
            }
            else
            {
                max_width = Math.max( max_width, next_task.day_end - first_task.day_start + 1);
                max_height = Math.max(max_height, next_task.height);
            }
        }

        System.out.print(ans);
    }
}