import java.io.*;
import java.util.*;

public class G1_2042
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] num = new long[N];

        for (int i=0; i<N; i++)
            num[i] = Long.parseLong(input.readLine());

        Segment_Tree seg = new Segment_Tree(num);

        for (int i=0; i<M+K; i++)
        {
            st = new StringTokenizer(input.readLine());

            int oper = Integer.parseInt(st.nextToken());
            long val_0 = Long.parseLong(st.nextToken());
            long val_1 = Long.parseLong(st.nextToken());

            switch(oper)
            {
                case 1:
                    seg.Update((int)val_0-1, val_1);
                    break;
                case 2:
                    sb.append(seg.Range_Operation((int)val_0-1, (int)val_1-1)).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }

    static class Segment_Tree
    {
        private long[] num;
        private long[] segment_tree;

        // ========
        // Public
        // ========

        public Segment_Tree(long[] num) 
        {
             this.num = num;
             segment_tree = new long[4*this.num.length + 1];

             Make_Segement_Tree(1, 0, num.length-1);
        }

        public long Range_Operation(int num_start, int num_end)
        {
            return Get_Range_Result(1, 0, num.length-1, num_start, num_end);
        }

        public void Update(int index, long value)
        {
            Update_Node(1, 0, num.length-1, index, value);
            //num[index] = value;
        }

        // =========
        // Private
        // =========

        private static long Operator(long left, long right)
        {
            return left + right;
        }

        private static long Identity()
        {
            // sum -> 0
            // min -> Long.MAX_VALUE
            // max -> Long.MIN_VALUE
            // gcd -> 0

            return 0;
        }

        private long Make_Segement_Tree(int node, int start, int end)
        {
            if (start == end)
                return segment_tree[node] = num[start];

            int mid = (start + end) >> 1;
            long left_result = Make_Segement_Tree(node << 1, start, mid);
            long right_result = Make_Segement_Tree(node << 1 | 1, mid+1, end);

            return segment_tree[node] = Operator(left_result, right_result);
        }

        private long Get_Range_Result(int node, int seg_start, int seg_end, int num_start, int num_end)
        {
            if (num_end < seg_start || seg_end < num_start)
                return Identity();

            if ( num_start <= seg_start && seg_end <= num_end )
                return segment_tree[node];

            int mid = (seg_start+seg_end) >> 1;
            long left_result = Get_Range_Result(node << 1, seg_start, mid, num_start, num_end);
            long right_result = Get_Range_Result(node << 1 | 1, mid+1, seg_end, num_start, num_end);

            return Operator(left_result, right_result);
        }

        private void Update_Node(int node, int seg_start, int seg_end, int num_index, long num_value)
        {
            if ( seg_start == seg_end )
            {
                segment_tree[node] = num_value;
                return;
            }
                
            int mid = (seg_start + seg_end) >> 1;

            if ( num_index <= mid )
                Update_Node(node << 1, seg_start, mid, num_index, num_value);
            else
                Update_Node(node << 1 | 1, mid+1, seg_end, num_index, num_value);

            segment_tree[node] = Operator(segment_tree[node << 1], segment_tree[node << 1 | 1]);
        }
    }
}