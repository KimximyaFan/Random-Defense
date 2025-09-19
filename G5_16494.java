import java.io.*;

public class G5_16494
{
    public static void main (String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        int N = readInt();
        int M = readInt();
        int[] arr = new int[N];

        for (int i=0; i<N; i++)
            arr[i] = readInt();

        System.out.print( BackTracking(arr, N, M, 0, 0) );
    }

    static int BackTracking (int[] arr, int N, int M, int depth, int index)
    {
        if ( depth == M-1 )
        {
            return Kadane(arr, index, N-1);
        }

        int current_kadane = 0;
        int calculated_kadane = 0;
        int max = Integer.MIN_VALUE;

        for (int i=index; i<=N-M+depth; i++)
        {
            current_kadane = Kadane(arr, index, i);
            calculated_kadane = BackTracking(arr, N, M, depth+1, i+1);
            max = Math.max(current_kadane + calculated_kadane, max);
        }

        return max;
    }

    static int Kadane (int[] arr, int start, int end)
    {
        int cur = arr[start];
        int max = cur;

        for (int i=start+1; i<=end; i++)
        {
            cur = Math.max(cur + arr[i], arr[i]);
            max = Math.max(max, cur);
        }

        return max;
    }

    static int readInt() throws IOException
    {
        int c, num = 0;
        boolean neg = false;
        while ((c = System.in.read()) <= 32);
        if (c == '-') { neg = true; c = System.in.read(); }
        do { num = (num << 3) + (num << 1) + (c & 15); } 
        while ((c = System.in.read()) >= '0' && c <= '9');
        return neg ? -num : num;
    }
}