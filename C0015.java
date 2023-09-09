import java.io.*;
import java.util.*;

public class C0015
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        while( true )
        {
            String s = input.readLine();

            if ( s == null || s.equals("")) {
                break;
            }

            int N = Integer.parseInt(s);
            ArrayList<HashSet<Character>> A = new ArrayList<>();
            int count = 0;

            for (int i=0; i<N; i++)
            {
                String a = input.readLine();
                int isSet = 0;

                A.add(new HashSet<>());

                for (int j=0; j<a.length(); j++)
                    A.get(A.size() - 1).add(a.charAt(j));

                for (int k=0; k<A.size()-1; k++)
                {
                    if ( A.get(k).equals( A.get(A.size()-1)) == false )
                        isSet++;
                }

                if ( A.size() == 1 || isSet == A.size()-1 )
                    count++;
            }

            System.out.println(count + "");
        }
    }
}