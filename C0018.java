import java.io.*;

public class C0018
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "";

        while ( (s = input.readLine()).equals("end") == false )
        {
            boolean isAccept = true;
            boolean isGather = false;
            int Ja = 0;
            int Mo = 0;

            for (int i=0; i<s.length(); i++)
            {
                if ( i >=1 && s.charAt(i) == s.charAt(i-1))
                {
                    if ( s.charAt(i) != 'e' && s.charAt(i) != 'o' )
                    {
                        isAccept = false;
                        break;
                    }
                }

                if ( s.charAt(i) == 'a' || 
                s.charAt(i) == 'e' ||
                s.charAt(i) == 'i' ||
                s.charAt(i) == 'o' ||
                s.charAt(i) == 'u' )
                {
                    isGather = true;
                    Mo++;
                    Ja = 0;

                    if ( Mo >= 3 )
                    {
                        isAccept = false;
                        break;
                    }
                }
                else
                {
                    Ja++;
                    Mo = 0;

                    if ( Ja >= 3 )
                    {
                        isAccept = false;
                        break;
                    }
                }
            }

            if ( isGather == false )
                isAccept = false;

            if ( isAccept == true )
                output.write("<" + s + "> " + "is acceptable.\n");
            else
                output.write("<" + s + "> " + "is not acceptable.\n");
        }

        output.close();
    }
}