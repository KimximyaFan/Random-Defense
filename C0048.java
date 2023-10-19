import java.io.*;

public class C0048
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print((int)Math.sqrt(Integer.parseInt(input.readLine())));
    }
}