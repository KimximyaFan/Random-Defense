import java.io.*;
import java.util.*;

public class S5_9626
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char[][] original_table = new char[M][N];

        st = new StringTokenizer(input.readLine());

        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        for (int i=0; i<M; i++)
        {
            String temp_str = input.readLine();
            
            for (int j=0; j<N; j++)
                original_table[i][j] = temp_str.charAt(j);
        }

        int X = M + U + D;
        int Y = N + L + R;
        boolean row_flag = false;
        boolean column_flag = false;
        char[][] table = new char[X][Y];

        for (int i=0; i<X; i++)
        {
            column_flag = row_flag;

            for (int j=0; j<Y; j++)
            {
                table[i][j] = column_flag == false ? '#' : '.';
                column_flag = !column_flag;
            }

            row_flag = !row_flag;
        }

        for (int i=0; i<M; i++)
            for (int j=0; j<N; j++)
                table[i+U][j+L] = original_table[i][j];
        
        for (int i=0; i<X; i++)
        {
            for (int j=0; j<Y; j++)
                sb.append(table[i][j]);

            sb.append("\n");
        }

        System.out.print(sb);
    }
}