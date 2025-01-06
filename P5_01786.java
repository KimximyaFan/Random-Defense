import java.io.*;
import java.util.*;

public class P5_01786
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String text = input.readLine();
        String pattern = input.readLine();

        ArrayList<Integer> pattern_pos = KMP(text, pattern);

        sb.append( pattern_pos.size() ).append("\n");
        
        for (int i=0; i<pattern_pos.size(); i++)
            sb.append(pattern_pos.get(i) + 1).append("\n");

        System.out.print(sb);
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

    static ArrayList<Integer> KMP (String text, String pattern)
    {
        ArrayList<Integer> pattern_pos = new ArrayList<>();
        int[] failure_func = Failure_Function_Computation(pattern);
        int pattern_pointer = 0;

        for (int i=0; i<text.length(); i++)
        {
            while ( pattern_pointer > 0 && text.charAt(i) != pattern.charAt(pattern_pointer) )
                pattern_pointer = failure_func[pattern_pointer-1];

            if ( text.charAt(i) == pattern.charAt(pattern_pointer) )
                pattern_pointer++;

            if ( pattern_pointer == pattern.length() )
            {
                pattern_pos.add(i - pattern_pointer + 1);
                pattern_pointer = failure_func[pattern_pointer-1];
            }
        }

        return pattern_pos;
    }
}