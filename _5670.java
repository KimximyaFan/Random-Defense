import java.io.*;
import java.util.*;

public class _5670
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = "";

        while ( (s = input.readLine()) != null && !s.isEmpty() )
        {
            int N = Integer.parseInt(s);

            Trie trie = new Trie();

            for (int i=0; i<N; i++)
                trie.Insert( input.readLine() );

            sb.append( String.format("%.2f", trie.Get_Average_Count()) ).append("\n");
        }

        System.out.print(sb);
    }

    static class Trie
    {
        private static class Node
        {
            HashMap<Character, Node> child = new HashMap<>();
            boolean is_end = false;
        }

        private final Node root = new Node();
        private int word_count = 0;
        private int total_input_count = 0;

        private void Traverse (Node current_node, int input_count)
        {
            if ( current_node.is_end == true )
                total_input_count += input_count;

            if ( current_node.child.size() > 1 || current_node.is_end == true || current_node == root )
                input_count++;

            for ( Character key : current_node.child.keySet() )
            {
                Node next_node = current_node.child.get(key);
                Traverse(next_node, input_count);
            }
        }

        double Get_Average_Count ()
        {
            Traverse(root, 0);
            return total_input_count / (double)word_count;
        }

        void Insert (String s)
        {
            word_count++;
            Node current_node = root;

            for (int i=0; i<s.length(); i++)
                current_node = current_node.child.computeIfAbsent(s.charAt(i), k -> new Node());

            current_node.is_end = true;
        }
    }
}