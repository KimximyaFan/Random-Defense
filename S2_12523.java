import java.io.*;
import java.util.*;

public class S2_12523
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(input.readLine());
        int test_case = 0;

        while (T-- > 0)
        {
            test_case++;

            int N = Integer.parseInt(input.readLine());

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            st = new StringTokenizer(input.readLine());

            for (int i=0; i<=N; i++)
                graph.add(new ArrayList<>());

            for (int i=1; i<=N; i++)
                graph.get(Integer.parseInt(st.nextToken())).add(i);

            sb.append("Case #").append(test_case).append(":\n");

            for (int i=1; i<=N; i++)
                sb.append(DFS(graph, new boolean[N+1], N, i, 0)).append("\n");
        }

        System.out.print(sb);
    }

    static int DFS (ArrayList<ArrayList<Integer>> graph, boolean[] is_visited, int N, int monk, int count)
    {
        is_visited[monk] = true;

        for (int i=0; i<graph.get(monk).size(); i++)
        {
            int next_monk = graph.get(monk).get(i);

            if ( is_visited[next_monk] == false )
                count = DFS(graph, is_visited, N, next_monk, count);
        }

        count++;

        return count;
    }
}