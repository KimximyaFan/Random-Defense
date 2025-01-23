import java.io.*;
import java.util.*;

public class G3_11690
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(input.readLine());

        ArrayList<Integer> prime = Sieve_Of_Eratosthenes((int)N);

        long divider = 4294967296L;
        long ans = 1L;

        for (int i=0; i<prime.size(); i++)
        {
            long current_prime = prime.get(i);
            long current_value = current_prime;
            
            while ( true )
            {
                if ( current_value * current_prime <= N )
                    current_value *= current_prime;                 
                else
                    break;
            }

            ans = (ans * current_value) % divider;
        }

        System.out.print(ans);
    }

    static ArrayList<Integer> Sieve_Of_Eratosthenes (int N)
    {
        ArrayList<Integer> al = new ArrayList<>();
        boolean[] check = new boolean[N+1];

        for (int i=2; i*i<=N; i++)
        {
            if ( check[i] == false )
            {
                for (int j=i*i; j<=N; j+=i)
                    check[j] = true;
            }
        }

        for (int i=2; i<=N; i++)
        {
            if ( check[i] == false )
                al.add(i);
        }

        return al;
    }
}