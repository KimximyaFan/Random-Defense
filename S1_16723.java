import java.io.*;

//16723
public class S1_16723
{
    public static void main (String[] args) throws IOException
    {
        long N = readInt();
        long V = 2*N;
        long k = 4;
        long r = 2;
        long ans = 0;
        long l = 0;

        while (true)
        {
            if ( r > V )
                break;

            l = (V - r)/ k;
            ans += (l+1)*r;

            k <<= 1;
            r <<= 1;
        }
        /*
            
            4k + 2
            8k + 4
            16k + 8
        */

        System.out.print(ans);
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