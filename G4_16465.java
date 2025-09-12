import java.io.*;
import java.util.*;

public class G4_16465
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int sum = 0;

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
            sum += Integer.parseInt(st.nextToken());

        if ( sum == M ) {
            System.out.print(0);
        }
        else if ( sum + L <= M ) {
            System.out.print(1);
        }
        else if ( L <= sum && sum <= M && L <= M ) {
            System.out.print(1);
        }
        else {
            System.out.print(-1);
        }
    }
}