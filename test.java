import java.io.*;
import java.util.*;

public class test
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(input.readLine());
        int K = Integer.parseInt(input.readLine());

        System.out.println("tree_size : " + subtreeSizeFast(N, K));
    }

    /*
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
    */

    public static int subtreeSizeFast(int N, int K) {
        if (K > N) return 0;
        
        long count = 0;
        long left = K, right = K;
    
        while (left <= N) {
            count += Math.min(right, N) - left + 1;
            left <<= 1;      // 왼쪽 자식 범위로 2배 확장
            right = (right << 1) + 1; // 오른쪽 자식 범위로 2배 + 1 확장
        }
        
        return (int) count;
    }
}