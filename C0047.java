import java.io.*;

public class C0047
{
    static boolean[] A;
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder();

        int T = Integer.parseInt(input.readLine());
        EraChae(1000000);

        while (T-- > 0)
            S.append(C(Integer.parseInt(input.readLine()))).append("\n");

        System.out.print(S);
    }

    static void EraChae (int N)
	{
		A = new boolean[N+1];
		
		for (int i=2; i*i<=N; i++)
		{	
			if ( A[i] == false )
			{
				for (int j=i*i; j<=N; j+=i)
					A[j] = true;
			}
		}
	}

    static int C (int N)
    {
        int count = 0;

        for (int i=2; i<=N/2; i++)
        {
            if ( A[i] == false && A[N-i] == false )
                count++;
        }

        return count;
    }
}