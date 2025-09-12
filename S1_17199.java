import java.io.*;
import java.util.*;

public class S1_17199
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());

        int[] out_degree = new int[N+1];

        for (int i=0; i<N-1; i++)
        {
            st = new StringTokenizer(input.readLine());

            int a = Integer.parseInt(st.nextToken());
            st.nextToken();

            out_degree[a]++;
        }

        int ans = -1;

        for (int i=1; i<=N; i++)
        {
            if ( out_degree[i] == 0 )
            {
                if ( ans != -1 )
                {
                    ans = -1;
                    break;
                }
                ans = i;
            }
        }

        System.out.print(ans);
    }
}