import java.io.*;
import java.util.*;

public class P2_28122
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        Trie trie = new Trie();

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
            trie.Insert( Long.parseLong(st.nextToken()) );
        
        System.out.print( trie.Get_Max_Count() );
    }

    static class Trie
    {
        private static class Node
        {
            Node[] child = new Node[2];
            int count = 0;
        }

        private final Node root = new Node();
        private int max = 0;

        private void Traverse (Node current_node, int depth, int used)
        {
            if ( current_node == null )
                return;

            if ( current_node.count == used )
                max = Math.max(max, depth);

            if ( depth == 62 )
                max = Math.max(max, depth + current_node.count - used );

            Node left_node = current_node.child[0];
            Node right_node = current_node.child[1];
            int left_count = left_node == null ? 0 : left_node.count;
            int right_count = right_node == null ? 0 : right_node.count;

            Traverse(left_node, depth+1, Math.max(1, used+1-right_count) );
            Traverse(right_node, depth+1, Math.max( 1, used+1-left_count) );
        }

        int Get_Max_Count ()
        {
            Traverse(root, 0, 0);
            return max;
        }

        void Insert (long x)
        {
            Node current_node = root;

            current_node.count++;

            for (int i=0; i<=61; i++)
            {
                int residue;

                if ( ( x & (1L << i) ) == 0 )
                    residue = 0;
                else
                    residue = 1;

                if ( current_node.child[residue] == null )
                    current_node.child[residue] = new Node();

                current_node = current_node.child[residue];
                current_node.count++;
            }
        }
    }
}