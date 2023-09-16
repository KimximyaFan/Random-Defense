import java.io.*;

public class C0020
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(input.readLine());

        long[] A = new long[116];

        A[0] = 1;
        A[1] = 1;
        A[2] = 1;

        for (int i=3; i<N; i++)
            A[i] = A[i-1] + A[i-3];
        
        output.write(A[N-1] + "");
        output.close();
    }
}