import java.io.*;
import java.util.*;

public class _27534
{
    /*
     
        의문점들
        
        1. left right 는 왜 0 based 이고, L은 왜 1 based인가?
        2. L이 의미하는 바가 뭔지?
        3. i와 j가 의미하는 바가 뭔지?
        4. cur_a, cur_b 가 의미하는바가 뭔지?
        5. cur_a와 cur_b 에 각각 cost_a cost_b를 할당하는 이유가 뭔지?
        6. if ( i <= j ) 가 의미하는 바가 뭔지?
        7. 거기서 s[i] == '0' 일때랑 s[i] == '1' 일 때 cur_a 값을 ++ 하는 이유가 뭔지? (똑같이 cur b 쪽도)
        8. 길이가 N/2 를 넘어가도 길이기 같은 경우를 안따져도 되는지?
        9. 항상 0 또는 1의 값이 보장 되는지? 
        무조건 2개 이상 바꿔야 하는 경우의 수 라는게 있을 지도 모르는거 아닌가? 그러면 min 값이 2 이상일건데
        문제 제한은 최대 1이란 말임

    */

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(input.readLine());

        while( T-- > 0 )
        {
            int N = Integer.parseInt(input.readLine());
            char[] s = input.readLine().toCharArray();

            if ( N == 1 || N == 3 )
            {
                sb.append(-1).append("\n");
                continue;
            }

            int cost_a = 0;
            int cost_b = 0;
            int best_a = Integer.MAX_VALUE;
            int best_b = Integer.MAX_VALUE;

            int left = 0;
            int right = N - 1;

            
            for (int L = 1; L <= N/2; L++)
            {
                if (s[left] == '1') cost_a++;
                if (s[right] == '0') cost_a++;
                if (s[left] == '0') cost_b++;
                if (s[right] == '1') cost_b++;

                left++;
                right--;

                int i = L;
                int j = N - L - 1;

                if (i == j) continue;

                int cur_a = cost_a;
                if (i <= j)
                {
                    if (s[i] == '0') cur_a++;
                    if (s[j] == '1') cur_a++;
                }
                best_a = Math.min(best_a, cur_a);

                int cur_b = cost_b;
                if (i <= j)
                {
                    if (s[i] == '1') cur_b++;
                    if (s[j] == '0') cur_b++;
                }
                best_b = Math.min(best_b, cur_b);
            }

            int ans = Math.min(best_a, best_b);
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
