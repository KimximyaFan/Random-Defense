import java.io.*;
import java.util.*;

public class S4_29721
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        HashMap<Long, Boolean> tile = new HashMap<>();

        long mul = 1000000;

        int[] x_ = new int[K];
        int[] y_ = new int[K];
        int[] dx = { 0, 0, 2, -2 };
        int[] dy = { 2, -2, 0, 0 };
        int count = 0;

        for (int i=0; i<K; i++)
        {
            st = new StringTokenizer(input.readLine());

            x_[i] = Integer.parseInt(st.nextToken());
            y_[i] = Integer.parseInt(st.nextToken());

            tile.put(x_[i]*mul + y_[i], true);
        }
        
        for (int i=0; i<K; i++)
        {
            int x = x_[i];
            int y = y_[i];

            for (int j=0; j<4; j++)
            {
                int next_x = x + dx[j];
                int next_y = y + dy[j];

                if ( next_x < 1 || next_x > N || next_y < 1 || next_y > N || tile.containsKey(next_x*mul + next_y) )
                    continue;

                tile.put(next_x*mul + next_y, true);
                count++;
            }
        }

        System.out.print(count);
    }
}