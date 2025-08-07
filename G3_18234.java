import java.io.*;
import java.util.*;

public class G3_18234
{
    static class Carrot implements Comparable<Carrot>
    {
        int w, p;

        Carrot (int w, int p) { this.w = w; this.p = p; }
        @Override
        public int compareTo(Carrot o) {
            return -this.p + o.p;
        }
    }
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        PriorityQueue<Carrot> carrots = new PriorityQueue<>();
        long ans = 0;

        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(input.readLine());

            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            carrots.add(new Carrot(w, p));
        }

        for (int i=1; i<=N; i++)
        {
            Carrot current_carrot = carrots.poll();
            long w = current_carrot.w;
            long p = current_carrot.p;
            ans += w + (T-i)*p; 
        }

        System.out.print(ans);
    }
}