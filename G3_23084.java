import java.io.*;

public class G3_23084
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String origin = input.readLine();

        int[] origin_char_count = new int[26];

        for (int i=0; i<origin.length(); i++)
            origin_char_count[ origin.charAt(i) - 'a' ]++;
        
        int N = Integer.parseInt(input.readLine());

        for (int i=0; i<N; i++)
        {
            if ( Check(origin, input.readLine()) )
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }

        System.out.print(sb);
    }

    static int Matching (int[] origin_count, int[] str_count)
    {
        int count = 0;
        
        for (int i=0; i<26; i++)
            count += Math.abs( origin_count[i] - str_count[i] );

        return count;
    }

    static boolean Check (String origin, String str)
    {
        int length = origin.length();
        boolean is_possible = false;
        int[] origin_count = new int[26];
        int[] str_count = new int[26];

        if ( str.length() < length )
            return is_possible;

        for (int i=0; i<origin.length(); i++)
        {
            origin_count[ origin.charAt(i) - 'a' ]++;
            str_count[ str.charAt(i) - 'a' ]++;
        }

        if ( str.length() == length )
        {
            int count = Matching(origin_count, str_count);

            if ( count == 2 )
                is_possible = true;

            return is_possible;
        }

        for (int i=0; i<=str.length()-length; i++)
        {
            if ( i != 0 )
            {
                str_count[str.charAt(i-1) - 'a']--;
                str_count[str.charAt(i+length-1) - 'a']++;
            }

            int count = Matching(origin_count, str_count);

            if ( count <= 2 )
            {
                is_possible = true;
                break;
            }
        }

        return is_possible;
    }
}