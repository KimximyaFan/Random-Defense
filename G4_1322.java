import java.io.*;
import java.util.ArrayList;

public class G4_1322
{
    static class Value
    {
        int actual_radix;
        Value (int ar) { this.actual_radix = ar; }
    }

    public static void main (String[] args) throws IOException
    {
        long X = readLong();
        long K = readLong();
        long ans = 0;

        ArrayList<Value> value_list = new ArrayList<>();

        for (int i=0; i<63; i++)
        {
            if ( (X & (1L << i)) == 0 )
                value_list.add(new Value(i));
        }

        for (int i=0; i<63; i++)
        {
            if ( (K & (1L << i)) == 0 )
                continue;

            ans += (1L << value_list.get(i).actual_radix);
        }

        System.out.print(ans);
    }

    static long readLong() throws IOException
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