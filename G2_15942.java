import java.io.*;
import java.util.*;

public class G2_15942
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        
        st = new StringTokenizer(input.readLine());

        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int subtree_size = Subtree_Size(N, p);
        int p_level = Level_Check(p);

        if ( k + subtree_size-1 > N || k < p_level)
            sb.append(-1);
        else
        {
            int[] heap_array = new int[N+1];
            boolean[] is_num_used = new boolean[N+1];

            Fill_The_Heap_Array(heap_array, is_num_used, N, k, p);

            for (int i=1; i<heap_array.length; i++)
                sb.append(heap_array[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static int Subtree_Size(int N, int K) {
        if (K > N) return 0;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(K);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node > N) continue;
            count++;
            queue.add(2 * node);
            queue.add(2 * node + 1);
        }
        return count;
    }

    public static int Level_Check (int k)
    {
        int level = 0;

        while (true)
        {
            level++;

            if ( 1 << (level-1) <= k && k <= (1 << level) - 1)
                break;
        }

        return level;
    }

    public static void Fill_The_Heap_Array (int[] heap_array, boolean[] is_num_used, int N, int k, int p)
    {
        int parent_index = p;
        int parent_value = k;

        while ( true )
        {
            parent_index >>= 1;

            if ( parent_index <= 0 )
                break;

            parent_value--;
            heap_array[parent_index] = parent_value;
            is_num_used[parent_value] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(p);

        while (!queue.isEmpty())
        {
            int node = queue.poll();

            if (node > N) continue;

            heap_array[node] = k;
            is_num_used[k] = true;
            k++;
            
            queue.add(2 * node);
            queue.add(2 * node + 1);
        }

        int value = 0;

        for (int i=1; i<heap_array.length; i++)
        {
            if ( heap_array[i] != 0 )
                continue;

            while (true)
            {
                value++;

                if ( value > N )
                    break;

                if ( is_num_used[value] == false )
                {
                    heap_array[i] = value;
                    is_num_used[value] = true;
                    break;
                }
            }
        }
    }
}