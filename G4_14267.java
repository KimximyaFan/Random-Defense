import java.io.*;
import java.util.*;

public class G4_14267
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        int[] complement_values = new int[n+1];

        for (int i=0; i<=n; i++)
            tree.add(new ArrayList<>());

        st = new StringTokenizer(input.readLine());
        st.nextToken();

        for (int i=2; i<=n; i++)
            tree.get(Integer.parseInt(st.nextToken())).add(i);
        
        for (int i=0; i<m; i++)
        {
            st = new StringTokenizer(input.readLine());

            int node = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            complement_values[node] += value;
        }

        Dfs(tree, complement_values, 1, 0);

        for (int i=1; i<=n; i++)
            sb.append(complement_values[i]).append(" ");

        System.out.print(sb);
    }

    static void Dfs (ArrayList<ArrayList<Integer>> tree, int[] complement_values, int node, int value)
    {
        complement_values[node] += value;

        for (int i=0; i<tree.get(node).size(); i++)
            Dfs(tree, complement_values, tree.get(node).get(i), complement_values[node]);
    }
}