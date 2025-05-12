import java.io.*;
import java.util.*;

public class G3_14725
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(input.readLine());
        Trie trie = new Trie();

        for (int i=0; i<N; i++)
        {
            String s = input.readLine().replaceFirst("^\\d+\\s+", "");
            trie.Insert(s);
        }

        System.out.print(trie.Get_Trie_Architecture());
    }

    static class Trie
    {
        private static class Node
        {
            TreeMap<String, Node> child = new TreeMap<>();
        }

        private final Node root = new Node();
        public StringBuilder sb = new StringBuilder();

        void Traverse (Node current_node, int depth)
        {
            for ( String key : current_node.child.keySet() )
            {
                for (int i=0; i<depth; i++)
                    sb.append("--");

                sb.append(key).append("\n");

                Node next_node = current_node.child.get(key);

                Traverse(next_node, depth+1);
            }
        }

        StringBuilder Get_Trie_Architecture ()
        {
            Traverse(root, 0);
            return sb;
        }

        void Insert (String s)
        {
            Node current_node = root;
            StringTokenizer st = new StringTokenizer(s);

            while ( st.hasMoreTokens() == true )
                current_node = current_node.child.computeIfAbsent(st.nextToken(), k -> new Node());
        }
    }
}