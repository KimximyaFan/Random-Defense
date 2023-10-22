import java.io.*;
import java.util.*;

public class C0052
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean isEnd_0 = false;
        boolean isEnd_1 = false;

        st = new StringTokenizer(input.readLine());

        long X1 = Long.parseLong(st.nextToken());
        long Y1 = Long.parseLong(st.nextToken());
        long X2 = Long.parseLong(st.nextToken());
        long Y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(input.readLine());

        long X3 = Long.parseLong(st.nextToken());
        long Y3 = Long.parseLong(st.nextToken());
        long X4 = Long.parseLong(st.nextToken());
        long Y4 = Long.parseLong(st.nextToken());

        if ( X1 < X3 && X1 < X4 && X2 < X3 && X2 < X4 )
            isEnd_0 = true;
        else if ( X1 > X3 && X1 > X4 && X2 > X3 && X2 > X4 )
            isEnd_0 = true;
        else if ( Y1 < Y3 && Y1 < Y4 && Y2 < Y3 && Y2 < Y4 )
            isEnd_0 = true;
        else if ( Y1 > Y3 && Y1 > Y4 && Y2 > Y3 && Y2 > Y4 )
            isEnd_0 = true;

        if ( isEnd_0 == true )
        {
            System.out.print("0");
            return;
        }
        
        boolean L1_Horizon = false;
        boolean L1_Vertical = false;
        boolean L2_Horizon = false;
        boolean L2_Vertical = false;

        if ( X2 - X1 == 0 )
            L1_Vertical = true;
        else if ( Y2 - Y1 == 0 )
            L1_Horizon = true;

        if ( X4 - X3 == 0 )
            L2_Vertical = true;
        else if ( Y4 - Y3 == 0 )
            L2_Horizon = true;

        if ( L1_Vertical == true )
        {
            if ( L2_Vertical == true )
                isEnd_0 = true;

            if ( L2_Horizon == true )
                isEnd_1 = true;
        }
        else if ( L1_Horizon == true )
        {
            if ( L2_Vertical == true )
                isEnd_1 = true;

            if ( L2_Horizon == true )
                isEnd_0 = true;
        }

        if ( isEnd_0 == true )
        {
            System.out.print("0");
            return;
        }
        else if ( isEnd_1 == true )
        {
            System.out.print("1");
            return;
        }

        if ( L1_Horizon == true )
        {
            double n = cross (X3, Y3, X4, Y4, Y1, false);

            if ( ((n >= X2 && n <= X1) || (n >= X1 && n <= X2)) &&
                ((n <= X3 && n >= X4) || (n <= X4 && n >= X3)))
                isEnd_1 = true;
            else
                isEnd_0 = true;
        }
        else if ( L1_Vertical == true )
        {
            double n = cross (X3, Y3, X4, Y4, X1, true);

            if ( ((n >= Y2 && n <= Y1) || (n >= Y1 && n <= Y2)) &&
                ((n >= Y3 && n <= Y4) || (n >= Y4 && n <= Y3)))
                isEnd_1 = true;
            else
                isEnd_0 = true;
        }
        else if ( L2_Horizon == true )
        {
            double n = cross (X1, Y1, X2, Y2, Y3, false);

            if ( ((n <= X3 && n >= X4) || (n >= X3 && n <= X4)) &&
                ((n >= X1 && n <= X2) || (n >= X2 && n <= X1)))
                isEnd_1 = true;
            else
                isEnd_0 = true;
        }
        else if ( L2_Vertical == true )
        {
            double n = cross (X1, Y1, X2, Y2, X3, true);

            if ( ((n <= Y3 && n >= Y4) || (n >= Y3 && n <= Y4)) &&
                ((n >= Y1 && n <= Y2) || (n >= Y2 && n <= Y1)))
                isEnd_1 = true;
            else
                isEnd_0 = true;
        }
        else if ( (Y4-Y3) * (X2-X1) == (Y2-Y1) * (X4-X3) )
            isEnd_0 = true;

        if ( isEnd_0 == true )
        {
            System.out.print("0");
            return;
        }
        else if ( isEnd_1 == true )
        {
            System.out.print("1");
            return;
        }

        double A = (Y4-Y3) / (double)(X4-X3);
        double B = (Y2-Y1) / (double)(X2-X1);
        double x = ((Y1-Y3) + (A*X3) - (B*X1)) / (A-B);

        if ( ((x >= X1 && x <= X2) || (x >= X2 && x <= X1)) &&
        ((x >= X3 && x <= X4) || (x >=X4 && x <= X3) ) )
            System.out.print("1");
        else
            System.out.print("0");
    }

    static double cross (Long X1, Long Y1, Long X2, Long Y2, Long n, boolean isY)
    {
        double a = (Y2-Y1) / (double)(X2-X1);

        if ( isY == true )
            return a * (n - X1) + Y1;
        else
            return ((n - Y1)/a) + X1;
    }
}