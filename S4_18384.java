import java.io.*;
import java.util.*;

public class S4_18384
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        ArrayList<Integer> prime_numbers = Sieve_Of_Eratosthenes(1000000);
        prime_numbers.add(1000003);

        for (int i=0; i<N; i++)
        {
            int sum = 0;

            st = new StringTokenizer(input.readLine());

            for (int j=0; j<5; j++)
                sum += Find_Not_Less_Prime(prime_numbers, Integer.parseInt(st.nextToken()));

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }

    static int Find_Not_Less_Prime (ArrayList<Integer> prime_numbers, int X)
    {
        int left = 0;
        int right = prime_numbers.size()-1;
        int mid, temp_prime;

        while ( left < right )
        {
            mid = (left + right)/2;

            temp_prime = prime_numbers.get(mid);

            if ( temp_prime < X )
                left = mid+1;
            else
                right = mid;
        }
        
        return prime_numbers.get(left);
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