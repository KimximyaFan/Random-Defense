import java.io.*;

public class S3_16341
{
    public static void main (String[] args) throws IOException
    {
        System.out.print( (readInt() + readInt())%2 == (readInt() + readInt())%2 ? "black" : "white" );
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