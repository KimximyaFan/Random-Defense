import java.io.*;
import java.util.*;

public class C0051
{
    static class vector
    {
        double x, y;
        vector (double x, double y) { this.x = x; this.y = y; }

        public double Cross (vector o)
        {
            return this.x * o.y - this.y * o.x;
        }
    }
    static final double PI = Math.PI;
    static int count = 40320;
    static int[] D = new int[8];
    static ArrayList<Integer> Q = new ArrayList<>();
    static boolean[] isVisited = new boolean[8];

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(input.readLine());

        for (int i=0; i<8; i++)
            D[i] = Integer.parseInt(st.nextToken());
        
        
        for (int i=0; i<8; i++)
        {
            isVisited[i] = true;
            Q.add(i);

            BackTrack(i, 0);

            isVisited[i] = false;
            Q.remove(Q.size()-1);
        }
        
        System.out.print(count);
    }

    static void BackTrack (int x, int depth)
    {
        if ( depth == 7 )
        {
            int[] Z = new int[8];
            double[] X = new double[8];
            double[] Y = new double[8];
            vector[] A = new vector[8];

            for (int i=0; i<8; i++)
                Z[i] = D[Q.get(i)];

            for (int i=0; i<8; i++)
            {
                double a = PI * ( 0.5 + (-0.25) * i );
                int d = Z[i];

                X[i] = d * (( Math.round(Math.cos(a) * 100000) ) / 100000.0);
                Y[i] = d * (( Math.round(Math.sin(a) * 100000) ) / 100000.0);
            }

            for (int i=0; i<8; i++)
            {
                int a = (i + 9) % 8;

                A[i] = new vector( X[a]-X[i], Y[a]-Y[i] );
            }
            
            for (int i=0; i<8; i++)
            {
                int a = (i + 9) % 8;
                double b = A[i].Cross(A[a]);
                
                if ( b > 0 )
                {
                    count--;
                    break;
                }
            }

            return;
        }
        
        for (int i=0; i<8; i++)
        {
            if ( isVisited[i] == false )
            {
                isVisited[i] = true;
                Q.add(i);

                BackTrack(i, depth+1);

                isVisited[i] = false;
                Q.remove(Q.size()-1);
            }
        }
    }
}