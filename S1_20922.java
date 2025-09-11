import java.io.*;

public class S1_20922
{
    public static void main (String[] args) throws IOException
    {
        int N = readInt();
        int K = readInt();
        int[] num = new int[N+1];
        int[] count = new int[100001];

        for (int i=0; i<N; i++)
            num[i] = readInt();

        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int len = 0;
        int current_num = num[0];
        boolean is_possible = true;

        while ( right < N )
        {
            if ( is_possible == true )
            {
                count[current_num]++;
                right++;
                len++;
                max = Math.max(max, len);
            }
            else
            {
                count[num[left]]--;
                len--;
                left++;
            }

            current_num = num[right];

            is_possible = count[current_num] + 1 <= K ? true : false;
        }

        System.out.print(max);
    }

    private static int readInt() throws IOException
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