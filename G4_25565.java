import java.io.*;

public class G4_25565
{
    static class Line
    {
        int low, high, index, count = 0;
        boolean is_row = false;

        Line () {}
        Line (int l, int h, boolean row, int idx)
        { 
            this.low = l; this.high = h; count = high - low + 1; index = idx;
            is_row = row;
        }
    }
    public static void main (String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        int N = readInt();
        int M = readInt();
        int K = readInt();
        int cnt = 0;
        int overlap = 0;
        final boolean CROSS = false;
        final boolean SAME_LINE = true;
        int[][] map = new int[N+2][M+2];

        for (int i=1; i<=N; i++)
        {
            for (int j=1; j<=M; j++)
            {
                map[i][j] = readInt();

                if ( map[i][j] == 1 )
                    cnt++;
            }
        }

        overlap = 2*K - cnt;
        sb.append(overlap).append("\n");

        if ( overlap == 0 )
        {
            System.out.print(0);
            return;
        }
        
        int x = 0, y = 0;
        boolean state = false;

        for (int i=1; i<=N; i++)
        {
            for (int j=1; j<=M; j++)
            {
                if ( map[i][j] == 1 )
                {
                    x = i;
                    y = j;
                    break;
                }
            }

            if ( x != 0 )
                break;
        }

        Line row_line = Get_Line(map, N, M, x, true);
        Line column_line = Get_Line(map, N, M, y, false);
        Line main_line = row_line.count >= column_line.count ? row_line : column_line; 

        state = main_line.count > K || main_line.count == overlap ? SAME_LINE : CROSS;

        if ( state == SAME_LINE )
        {
            int low = main_line.low;
            int high = main_line.high;
            int index = main_line.index;
            boolean is_row = main_line.is_row;
            int start = high-K+1;
            int end = low+K-1;
            
            for (int i=start; i<=end; i++)
            {
                if ( is_row )
                    sb.append(index + " " + i).append("\n");
                else
                    sb.append(i + " " + index).append("\n");
            }
        }
        else
        {
            boolean is_row = !main_line.is_row;
            Line next_line = new Line();

            for (int i=main_line.low; i<=main_line.high; i++)
            {
                next_line = Get_Line(map, N, M, i, is_row);

                if ( next_line.count > 1 )
                    break;
            }

            if ( main_line.is_row )
                sb.append(main_line.index + " " + next_line.index);
            else
                sb.append(next_line.index + " " + main_line.index);
        }

        System.out.print(sb);
    }

    static Line Get_Line (int[][] map, int N, int M, int index, boolean is_row)
    {
        int low = 0;
        int high = 0;

        if ( is_row )
        {
            for (int i=1; i<=M+1; i++)
            {
                if ( low == 0 && map[index][i] == 1 )
                    low = i;

                if ( low != 0 && map[index][i] == 0 )
                {
                    high = i-1;
                    break;
                }
                    
            }
        }
        else
        {
            for (int i=1; i<=N+1; i++)
            {
                if ( low == 0 && map[i][index] == 1 )
                    low = i;

                if ( low != 0 && map[i][index] == 0 )
                {
                    high = i-1;
                    break;
                }
            }
        }

        return new Line(low, high, is_row, index);
    }

    static int readInt() throws IOException
    {
        int c, num = 0;
        boolean neg = false;
        while ((c = System.in.read()) <= 32);
        if (c == '-') { neg = true; c = System.in.read(); }
        do { num = (num << 3) + (num << 1) + (c & 15); } 
        while ((c = System.in.read()) >= '0' && c <= '9');
        return neg ? -num : num;
    }
}