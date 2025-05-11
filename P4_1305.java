import java.io.*;

public class P4_1305
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(input.readLine());

        String s = input.readLine();

        int[] failure_func = Failure_Function_Computation(s);

        System.out.print(L - failure_func[failure_func.length - 1]);
    }

    static int[] Failure_Function_Computation (String pattern)
    {
        int[] failure_func = new int[pattern.length()];
        int prefix_pointer = 0;

        for (int i=1; i<pattern.length(); i++)
        {
            while ( prefix_pointer > 0 && pattern.charAt(prefix_pointer) != pattern.charAt(i) )
                prefix_pointer = failure_func[prefix_pointer-1];

            if ( pattern.charAt(prefix_pointer) == pattern.charAt(i) )
                prefix_pointer++;

            failure_func[i] = prefix_pointer;
        }

        return failure_func;
    }
}