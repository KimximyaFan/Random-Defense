import java.io.*;

public class G5_11729
{
    static StringBuilder sb = new StringBuilder();

    static int[][] preprocess_mid = {
        { 0, 0, 0, 0 },
        { 0, 0, 3, 2 },
        { 0, 3, 0, 1 },
        { 0, 2, 1, 0 }
    };

    static String[][] preprocess_table = {
        { "", "",    "",    ""    },
        { "", "",    "1 2\n", "1 3\n" },
        { "", "2 1\n", "",    "2 3\n" },
        { "", "3 1\n", "3 2\n", ""    }
    };
    
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        sb.append( ( 1 << N ) - 1 ).append("\n");
        Hanoi(N, 1, 3);
        System.out.print(sb); 
    }

    static void Hanoi (int k, int from, int to)
    {
        if ( k == 1 )
        {
            sb.append(preprocess_table[from][to]);
            return;
        }

        Hanoi(k-1, from, preprocess_mid[from][to]);
        sb.append(preprocess_table[from][to]);
        Hanoi(k-1, preprocess_mid[from][to], to);
    }
}