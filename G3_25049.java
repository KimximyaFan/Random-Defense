import java.io.*;

public class G3_25049
{
    public static void main (String[] args) throws IOException
    {
        int N = readInt();
        long[] arr = new long[N];
        long sum = 0;

        for (int i=0; i<N; i++)
        {
            arr[i] = readInt();
            sum += arr[i];
        }

        long[] left = Kadane_Left(arr);
        long[] right = Kadane_Right(arr);
        long max = 0;

        for (int i=0; i<N-1; i++)
        {
            max = Math.max(max, left[i] + right[i+1]);
        }

        System.out.print( sum + Math.max( left[N-1],  max ) );
    }

    static long Kadane (long[] arr)
    {
        long cur = arr[0];
        long max = cur;

        for (int i=1; i<arr.length; i++)
        {
            cur = Math.max(cur + arr[i], arr[i]);
            max = Math.max(max, cur);
        }

        return max;
    }

    static long[] Kadane_Left (long[] arr)
    {
        long[] val = new long[arr.length];
        long cur = arr[0];
        val[0] = arr[0];

        for (int i=1; i<arr.length; i++)
        {
            cur = Math.max(cur + arr[i], arr[i]);
            val[i] = Math.max(cur, val[i-1]);
        }

        return val;
    }

    static long[] Kadane_Right (long[] arr)
    {
        int length = arr.length;
        long[] val = new long[length];
        long cur = arr[length-1];
        val[length-1] = arr[length-1];

        for (int i=length-2; i>=0; i--)
        {
            cur = Math.max(cur + arr[i], arr[i]);
            val[i] = Math.max(cur, val[i+1]);
        }

        return val;
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