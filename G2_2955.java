import java.io.*;
import java.util.*;

public class G2_2955
{
    static class Pos
    {
        int x, y;
        Pos (int x, int y) { this.x = x; this.y = y; }
    }
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] sudoku = new char[9][9];
        boolean is_error = false;

        for (int i=0; i<9; i++)
        {
            String s = input.readLine();

            for (int j=0; j<9; j++)
                sudoku[i][j] = s.charAt(j);
        }

        while ( true )
        {
            char[][] before_sudoku = Deep_Copy(sudoku);

            for (int i=1; i<=9; i++)
            {
                is_error = Cross_Hatching(sudoku, i);

                if ( is_error == true )
                    break;
            }

            boolean is_same = Same_Check(before_sudoku, sudoku);

            if ( is_same == true || is_error == true )
                break;
        }
        
             
        if (is_error == true)
            sb.append("ERROR");
        else
        {
            for (int i=0; i<9; i++)
            {
                for (int j=0; j<9; j++)
                    sb.append(sudoku[i][j]);

                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    static boolean Same_Check (char[][] before_sudoku, char[][] sudoku)
    {
        boolean is_same = true;

        for (int i=0; i<9; i++)
        {
            for (int j=0; j<9; j++)
            {
                if ( before_sudoku[i][j] != sudoku[i][j] )
                {
                    is_same = false;
                    break;
                }
            }
        }

        return is_same;
    }

    static char[][] Deep_Copy (char[][] sudoku)
    {
        char[][] copied = new char[9][9];

        for (int i=0; i<9; i++)
        {
            for (int j=0; j<9; j++)
                copied[i][j] = sudoku[i][j];
        }

        return copied;
    }

    static Pos Check_3x3 (char[][] copied, int index)
    {
        int base_x = 3 * (index / 3);
        int base_y = 3 * (index % 3);
        int count = 0;
        Pos return_pos = new Pos(0, 0);

        for (int i=base_x; i<base_x+3; i++)
        {
            for (int j=base_y; j<base_y+3; j++)
            {
                if ( copied[i][j] == '.' )
                {
                    if ( count == 0 )
                    {
                        return_pos.x = i;
                        return_pos.y = j;
                    }

                    count++;
                }
                else if ( copied[i][j] == '#' )
                    count += 10;
            }
        }

        if ( count == 0 )
            return_pos.x = -1;
        else if ( count > 1 )
            return_pos.x = -2;

        return return_pos;
    }

    static boolean Cross_Hatching (char[][] sudoku, int num)
    {
        boolean is_error = false;
        Queue<Pos> pos_queue = new LinkedList<>();
        char[][] copied = Deep_Copy(sudoku);

        for (int i=0; i<9; i++)
        {
            for (int j=0; j<9; j++)
            {
                if ( sudoku[i][j] - '0' == num )
                    pos_queue.add(new Pos(i, j)); 
            }
        }

        while (!pos_queue.isEmpty())
        {
            Pos current_pos = pos_queue.poll();
            int x = current_pos.x;
            int y = current_pos.y;
            copied[x][y] = '#';

            for (int i=0; i<9; i++)
            {
                if ( copied[x][i] - '0' == num )
                {
                    is_error = true;
                    break;
                }

                if ( copied[x][i] != '#' )
                    copied[x][i] = '*';
                
            }

            for (int i=0; i<9; i++)
            {
                if ( copied[i][y] - '0' == num )
                {
                    is_error = true;
                    break;
                }
                
                if ( copied[i][y] != '#' )
                    copied[i][y] = '*';
            }

            int base_x = 3 * (x/3);
            int base_y = 3 * (y/3);

            for (int i=base_x; i<base_x+3; i++)
            {
                for (int j=base_y; j<base_y+3; j++)
                {
                    if ( copied[i][j] - '0' == num )
                    {
                        is_error = true;
                        break;
                    }

                    if ( copied[i][j] != '#' )
                        copied[i][j] = '*';
                }
            }

            if ( is_error == true )
                break;
        }

        if ( is_error == true )
            return is_error;

        for (int i=0; i<9; i++)
        {
            Pos possible_pos = Check_3x3(copied, i);

            if ( possible_pos.x == -2 )
                continue;

            if ( possible_pos.x == -1 )
            {
                is_error = true;
                break;
            }

            sudoku[possible_pos.x][possible_pos.y] = (char)('0' + num);
        }

        return is_error;
    }
}