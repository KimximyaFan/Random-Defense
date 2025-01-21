import java.io.*;
import java.util.*;

public class S4_27535
{
    static class Choco implements Comparable<Choco>
    {
        int count;
        char type;

        Choco (int count, char type) { this.count = count; this.type = type; }

        public int compareTo (Choco o)
        {
            if ( this.count == o.count )
                return this.type - o.type;

            return o.count - this.count;
        }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int M, count, total_count = 0;
        ArrayList<Choco> choco_list = new ArrayList<>();

        st = new StringTokenizer(input.readLine());

        total_count += count = Integer.parseInt(st.nextToken());
        choco_list.add( new Choco(count, 'H') );
        total_count += count = Integer.parseInt(st.nextToken());
        choco_list.add( new Choco(count, 'T') );
        total_count += count = Integer.parseInt(st.nextToken());
        choco_list.add( new Choco(count, 'C') );
        total_count += count = Integer.parseInt(st.nextToken());
        choco_list.add( new Choco(count, 'K') );
        total_count += count = Integer.parseInt(st.nextToken());
        choco_list.add( new Choco(count, 'G') );

        M = Integer.parseInt(input.readLine());

        while ( M-- > 0 )
        {
            st = new StringTokenizer(input.readLine());

            int radix_value = total_count % 10;

            for (int i=0; i<choco_list.size(); i++)
            {
                int eating_count = Integer.parseInt(st.nextToken());
                choco_list.get(i).count -= eating_count;
                total_count -= eating_count;
            }

            if ( radix_value <= 1 )
                radix_value = 10;

            int copied_count = total_count;
            StringBuilder temp = new StringBuilder();

            while ( true )
            {
                temp.insert(0, copied_count % radix_value);
                copied_count /= radix_value;

                if ( copied_count < radix_value )
                {
                    if ( copied_count > 0 )
                        temp.insert(0, copied_count);

                    break;
                }
            }

            sb.append(temp).append("7H\n");

            ArrayList<Choco> copied_list = new ArrayList<>();

            for (int i=0; i<choco_list.size(); i++)
                copied_list.add( new Choco(choco_list.get(i).count, choco_list.get(i).type));
            
            Collections.sort(copied_list);

            for (int i=0; i<copied_list.size(); i++)
            {
                if ( copied_list.get(i).count > 0 )
                    sb.append(copied_list.get(i).type);
            }

            if ( total_count <= 0 )
                sb.append("NULL");

            sb.append("\n");
        }

        System.out.print(sb);
    }
}