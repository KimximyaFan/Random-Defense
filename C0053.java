import java.io.*;
import java.util.*;

public class C0053
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder();
        StringTokenizer st;

        Stack<Integer> Stack = new Stack<>();

        int N = Integer.parseInt(input.readLine());

        while (N-- > 0)
        {
            st = new StringTokenizer(input.readLine());

            int A = Integer.parseInt(st.nextToken());

            if ( A == 1 )
                Stack.push( Integer.parseInt(st.nextToken()) );
            else if ( A == 2 )
            {
                if ( Stack.isEmpty() )
                    S.append(-1).append("\n");
                else
                    S.append(Stack.pop()).append("\n");
            }
            else if ( A == 3 )
                S.append(Stack.size()).append("\n");
            else if ( A == 4 )
            {
                if ( Stack.isEmpty() )
                    S.append(1).append("\n");
                else
                    S.append(0).append("\n");
            }
            else if ( A == 5 )
            {
                if ( Stack.isEmpty() )
                    S.append(-1).append("\n");
                else
                    S.append(Stack.peek()).append("\n");
            }
        }

        System.out.print(S);
    }
}