import java.io.*;

public class S5_4402
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = "";

        int[] code = new int[26];
        code['B' - 'A'] = 1;
        code['F' - 'A'] = 1;
        code['P' - 'A'] = 1;
        code['V' - 'A'] = 1;

        code['C' - 'A'] = 2;
        code['G' - 'A'] = 2;
        code['J' - 'A'] = 2;
        code['K' - 'A'] = 2;
        code['Q' - 'A'] = 2;
        code['S' - 'A'] = 2;
        code['X' - 'A'] = 2;
        code['Z' - 'A'] = 2;

        code['D' - 'A'] = 3;
        code['T' - 'A'] = 3;

        code['L' - 'A'] = 4;

        code['M' - 'A'] = 5;
        code['N' - 'A'] = 5;

        code['R' - 'A'] = 6;


        while ( (s = input.readLine()) != null && !s.isEmpty() )
        {
            int before_code = -1;
            int current_code = -1;
            char current_char;

            for (int i=0; i<s.length(); i++)
            {
                current_char = s.charAt(i);
                current_code = code[current_char - 'A'];

                if ( current_code != 0 && current_code != before_code )
                    sb.append(current_code);

                before_code = current_code;
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}