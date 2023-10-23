import java.io.*;
import java.util.*;

public class C0054
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        input.readLine();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int count = 1;

        Stack<Integer> S = new Stack<>();

        while ( st.hasMoreTokens() )
        {
            int n = Integer.parseInt(st.nextToken());

            if ( n == count )
                count++;
            else
                S.push(n);

            while ( !S.isEmpty() && S.peek() == count )
            {
                S.pop();
                count++;
            }
        }

        if ( S.isEmpty() )
            System.out.print("Nice");
        else
            System.out.print("Sad");
    }
}