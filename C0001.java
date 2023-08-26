import java.io.*;
import java.util.*;

public class C0001 {
    public static void main (String[] args) throws IOException{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] T = new int[11];
        int V = 0;
        int sum = 0;
        int D = 0;

        for (int i=0; i<11; i++)
        {
            st = new StringTokenizer(input.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            V += 20 * Integer.parseInt(st.nextToken());
        }

        Arrays.sort(T);

        for (int i=0; i<11; i++)
        {
            sum += T[i];
            D += sum;
        }

        output.write( D + V + "");
        output.close();
    }
}
