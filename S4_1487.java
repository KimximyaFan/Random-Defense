import java.io.*;
import java.util.*;

public class S4_1487
{
    static class Pair
    {
        int price, delivery_cost;
        Pair (int p, int d) { this.price = p; this.delivery_cost = d; }
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        Pair[] customer = new Pair[N];

        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(input.readLine());
            customer[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int selected_price = 0;
        int max_profit = 0;

        for (int i=0; i<N; i++)
        {
            int calculated_profit = Calculate_Profit(customer, N, i);

            if ( max_profit < calculated_profit )
            {
                max_profit = calculated_profit;
                selected_price = customer[i].price;
            }
            else if ( max_profit == calculated_profit )
                selected_price = Math.min(selected_price, customer[i].price);
        }

        System.out.print(selected_price);
    }

    static int Calculate_Profit (Pair[] customer, int N, int index)
    {
        int profit = 0;
        int selected_price = customer[index].price;

        for (int i=0; i<N; i++)
        {
            if ( customer[i].price >= selected_price )
                profit += Math.max( selected_price - customer[i].delivery_cost, 0);
        }

        return profit;
    }
}