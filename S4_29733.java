import java.io.*;
import java.util.*;

public class S4_29733
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        char[][][] cube = new char[H+2][R+2][C+2];

        for (int k=1; k<=H; k++)
        {
            for (int i=1; i<=R; i++)
            {
                String s = input.readLine();

                for (int j=1; j<=C; j++)
                    cube[k][i][j] = s.charAt(j-1);
            }
        }

        for (int k=1; k<=H; k++)
        {
            for (int i=1; i<=R; i++)
            {
                for (int j=1; j<=C; j++)
                {
                    if ( cube[k][i][j] != '*')
                        cube[k][i][j] = (char)('0' + Mine_Count(cube, k, i, j));

                    sb.append(cube[k][i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    static int Mine_Count (char[][][] cube, int z, int x, int y)
    {
        int count = 0;

        for (int k=z-1; k<=z+1; k++)
        {
            for (int i=x-1; i<=x+1; i++)
            {
                for (int j=y-1; j<=y+1; j++)
                {
                    if ( cube[k][i][j] == '*' )
                        count++;
                }
            }
        }

        return count % 10;
    }
}