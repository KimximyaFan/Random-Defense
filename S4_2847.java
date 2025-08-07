import java.io.*;

public class S4_2847
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(input.readLine());
        int[] num = new int[N];
        int ans = 0;

        for (int i=0; i<N; i++)
            num[i] = Integer.parseInt(input.readLine());
        
        for (int i=N-1; i>=1; i--)
            if ( num[i-1] >= num[i] )
            {
                ans += num[i-1] - num[i] + 1;
                num[i-1] = num[i] - 1; 
            }

        System.out.print(ans);
    }
}