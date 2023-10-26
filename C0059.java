import java.io.*;
import java.util.*;

public class C0059
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double r1 = Double.parseDouble(st.nextToken());
        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        double r2 = Double.parseDouble(st.nextToken());
        double ans = 0;

        double l = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));

        if ( l >= r1 + r2 )
            ans = 0.0000;
        else if ( l + Math.min(r1,r2) <= Math.max(r1, r2) )
            ans = Math.PI * Math.min(r1, r2) * Math.min(r1, r2);
        else
        {
            double angle1 = Math.acos( (l*l + r1*r1 -r2*r2) / (2*l*r1) );
            double angle2 = Math.acos( (l*l + r2*r2 -r1*r1) / (2*l*r2) );
            double space1 = r1*r1*angle1 - 0.5*r1*r1*Math.sin(2*angle1);
            double space2 = r2*r2*angle2 - 0.5*r2*r2*Math.sin(2*angle2);
            ans = space1 + space2;
        }

        System.out.print( String.format( "%.3f", ans) );
    }
}