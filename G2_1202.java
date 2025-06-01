import java.io.*;
import java.util.*;

public class G2_1202
{
    private static class Jewel implements Comparable<Jewel>
    {
        int M, V;

        Jewel (int m, int v) { this.M = m; this.V = v; }

        public int compareTo(Jewel o)
        {
            return this.M - o.M;
        }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long ans = 0;

        PriorityQueue<Jewel> jewel = new PriorityQueue<>();
        PriorityQueue<Jewel> possible_jewel = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.V, a.V)
        );

        int[] C = new int[K];

        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(input.readLine());

            jewel.add( new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) );
        }

        for (int i=0; i<K; i++)
            C[i] = Integer.parseInt(input.readLine());

        Arrays.sort(C);

        for (int i=0; i<K; i++)
        {
            while ( jewel.isEmpty() == false )
            {
                if ( jewel.peek().M  > C[i] )
                    break;
                    
                possible_jewel.add( jewel.poll() );
            }

            if ( possible_jewel.isEmpty() == true )
                continue;

            ans += possible_jewel.poll().V;
        }

        System.out.print(ans);
    }
}