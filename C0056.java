import java.io.*;
import java.util.*;

public class C0056
{
    static int count = 0;
    static int[] D = new int[8];
    static int[] temp = new int[8];
    static boolean[] isVisit = new boolean[8];
    static final double angle = Math.PI/4;
    static final double start = 2 * angle;

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        for (int i=0; i<=7; i++)
            D[i] = Integer.parseInt(st.nextToken());

        backTrack(0);

        System.out.print(count);
    }

    static void backTrack (int depth)
    {
        if ( depth == 8 )
        {
            for (int i=0; i<=7; i++)
            {
                int j = (i+1) % 8;
                int k = (i+2) % 8;

                double a = start - i * angle;
                double b = start - j * angle;
                double c = start - k * angle;

                if ( CCW( temp[i] * Math.cos(a), temp[i] * Math.sin(a), 
                    temp[j] * Math.cos(b), temp[j] * Math.sin(b), 
                    temp[k] * Math.cos(c), temp[k] * Math.sin(c) ) == 1 )
                    return;
            }

            count++;
        }

        for (int i=0; i<=7; i++)
        {
            if ( isVisit[i] == false )
            {
                temp[depth] = D[i];
                isVisit[i] = true;

                backTrack(depth+1);

                isVisit[i] = false;
            }
        }
    }

    static int CCW (double x1, double y1, double x2, double y2, double x3, double y3)
    {
        double a = x1 * y2 + x2 * y3 + x3 * y1;
        double b = x1 * y3 + x3 * y2 + x2 * y1;

        if ( a-b > 0)
            return 1;
        else
            return -1;
    }
}