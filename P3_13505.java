import java.io.*;
import java.util.*;

public class P3_13505
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(input.readLine());
        int[] value = new int[N];
        int max = 0;
        Trie trie = new Trie();

        st = new StringTokenizer(input.readLine());

        for (int i=0; i<N; i++)
        {
            value[i] = Integer.parseInt(st.nextToken());
            trie.Insert(value[i]);
        }

        for (int i=0; i<N; i++)
            max = Math.max( max, trie.Get_Max_Value(value[i]) );
        
        System.out.print(max);
    }

    static class Trie
    {
        private static class Node
        {
            Node[] child = new Node[2];
            int value = 0;
            boolean is_end = false;
        }

        private final Node root = new Node();

        private int Traverse (Node current_node, int x, int depth)
        {
            if ( current_node.is_end == true )
                return current_node.value ^ x;

            int index = ((x >> depth) & 1) ^ 1;

            if ( current_node.child[index] == null )
                index ^= 1;
                
            return Traverse( current_node.child[index], x, depth-1 );
        }

        int Get_Max_Value(int x)
        {
            return Traverse(root, x, 30);
        }

        void Insert (int x)
        {
            Node current_node = root;

            for (int i=30; i>=0; i--)
            {
                int index = (x >> i) & 1;

                if (current_node.child[index] == null)
                    current_node.child[index] = new Node();

                current_node = current_node.child[ index ];
            }

            current_node.is_end = true;
            current_node.value = x;
        }
    }
}