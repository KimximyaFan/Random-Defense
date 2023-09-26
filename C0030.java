import java.io.*;

public class C0030
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char[] s = input.readLine().toCharArray();
        int ans = -1;
        int left = 0;
        int right = s.length-1;
        boolean a = true;
        boolean b = true;

        while ( left < right )
        {
            if ( s[left] != s[right] )
            {
                b = false;
                break;
            }
            else if ( s[left] != s[left+1] )
                a = false;

            left++;
            right--;
        }

        if ( b == false )
            ans = s.length;
        else if ( a == false )
            ans = s.length-1;

        output.write( ans + "" );
        output.close();
    }
}