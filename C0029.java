import java.io.*;

public class C0029
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = input.readLine();
        boolean isOver = false;
        boolean isAllsame = true;
        int ans = -1;

        for (int i=0; i<s.length(); i++)
        {
            if ( s.charAt(i) != s.charAt(0) )
            {
                isAllsame = false;
                break;
            }
        }

        if ( isAllsame == false )
        {
            for (int d=s.length(); d>=2; d--)
            {
                for (int i=0; i<s.length()-d+1; i++)
                {
                    String temp = s.substring(i, i + d);

                    if ( check(temp) == false )
                    {
                        ans = temp.length();
                        isOver = true;
                        break;
                    }
                }

                if ( isOver == true )
                    break;
            }
        }
        
        output.write( ans + "");
        output.close();
    }

    static boolean check (String s)
    {
        int left = 0;
        int right = s.length()-1;
        boolean isPalin = true;

        while ( left < right )
        {
            if ( s.charAt(left) != s.charAt(right) )
            {
                isPalin = false;
                break;
            }
            left++;
            right--;
        }

        return isPalin;
    }
}