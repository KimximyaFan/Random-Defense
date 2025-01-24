import java.io.*;
import java.util.*;

public class G4_28423
{
    static int[] g = new int[100001];
    static final int CHECKED = 2;
    static final int UNCHECKED = 3;

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int ans = 0;

        Arrays.fill(g, UNCHECKED);

        for (int i=L; i<=R; i++)
            ans += dfs( i );

        System.out.print(ans);
    }

    static boolean Has_Value (int current_value)
    {
        return g[current_value] <= 1 ? true : false;
    }

    static int f (int N)
    {
        int place_sum = 0;
        int place_multiply = 1;
        int copied_value = N;

        while ( copied_value > 0 )
        {
            int current_value = copied_value % 10;

            place_sum += current_value;
            place_multiply *= current_value;
            copied_value /= 10;
        }

        return Integer.parseInt( place_sum + "" + place_multiply );
    }

    static int dfs (int current_value)
    {
        if ( current_value > 100000 )
            return -1;

        else if ( Has_Value(current_value) == true )
            return g[current_value];

        else if ( g[current_value] == CHECKED )
        {
            if ( current_value == f(current_value) )
                return 1;
            else
                return 0;
        }

        g[current_value] = CHECKED;
        int value = dfs( f(current_value) );
        g[current_value] = value;

        return g[current_value];
    }
}