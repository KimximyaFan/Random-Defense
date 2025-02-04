import java.io.*;

public class G3_7894
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(input.readLine());

        while ( T-- > 0 )
        {
            int m = Integer.parseInt(input.readLine());
            double sum = 0.0;

            for (int i =1; i<=m; i++)
                sum += Math.log10(i);

            sb.append( (int)sum + 1 ).append("\n");
        }

        System.out.print(sb);
    }
}