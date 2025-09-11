import java.io.*;

public class G5_31600
{
    static class Table
    {
        String table;
        int count_0 = 0;
        int count_1 = 0;
        int flag = 0;

        Table (String table)
        {
            this.table = table;

            for (int i=0; i<table.length(); i++)
            {
                if ( table.charAt(i) == '0')
                    count_0++;
            }

            count_1 = table.length() - count_0;

            if ( count_0 >= count_1 )
                flag = 1;
            else
                flag = 2;
        }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(input.readLine());
        Table[] tables = new Table[N];

        int count_0 = 0;
        int count_1 = 0;
        int sum_min = 0;
        int diff_min = Integer.MAX_VALUE;
        int flag = 0;

        for (int i=0; i<N; i++)
        {
            tables[i] = new Table( input.readLine() );
            int cnt_0 = tables[i].count_0;
            int cnt_1 = tables[i].count_1;

            sum_min += Math.min(cnt_0, cnt_1);
            diff_min = Math.min(diff_min, Math.abs(cnt_0 - cnt_1));
            count_0 += cnt_0;
            count_1 += cnt_1;

            flag = flag | tables[i].flag;
        }
        
        if ( count_0 == 0 || count_1 == 0 )
        {
            System.out.print(0);
            return;
        }

        if ( flag == 3 )
        {
            System.out.print(sum_min);
            return;
        }
            
        System.out.print(sum_min + diff_min);
    }
}