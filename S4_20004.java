import java.io.*;
import java.util.*;

public class S4_20004
{
    public static void main (String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        
        int A = readInt();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i=1; i<=A; i++)
        {
            int a = 30;
            int k = i+1;

            while ( true )
            {
                if ( a - k <= 0)
                    break;

                a -= k;
            }

            if ( a > i )
                result.add(i);
        }

        for (Integer i : result)
            sb.append(i).append("\n");

        System.out.print(sb);
    }

    static int readInt() throws IOException
    {
        int c, num = 0;
        boolean neg = false;
        while ((c = System.in.read()) <= 32);
        if (c == '-') { neg = true; c = System.in.read(); }
        do { num = (num << 3) + (num << 1) + (c & 15); } 
        while ((c = System.in.read()) >= '0' && c <= '9');
        return neg ? -num : num;
    }
}