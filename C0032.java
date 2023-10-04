import java.io.*;

public class C0032
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder s = new StringBuilder("");
        int N = Integer.parseInt(input.readLine());
        int mid = N/2;

        if ( N == 1 )
        {
            output.write("1");
            output.close();
            return;
        }

        for (int i=1; i<=mid; i++)
        {
            s.append(mid + i + " ");
            s.append(i + " ");
        }

        if ( N % 2 == 1 )
            s.append(N + "");

        output.write(s.toString());
        output.close();
    }
}