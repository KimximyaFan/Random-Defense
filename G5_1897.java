import java.io.*;
import java.util.*;

public class G5_1897
{
    static class Node
    {
        String s;
        ArrayList<Node> next_list = new ArrayList<>();

        Node (String s) { this.s = s; }
    }

    static int max_depth = 0;
    static boolean[] is_selected;
    static String[] word_arr;
    static int N;
    static String ans;

    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        N = Integer.parseInt(st.nextToken());
        String word = st.nextToken();
        word_arr = new String[N];
        is_selected = new boolean[N];

        for (int i=0; i<N; i++)
            word_arr[i] = input.readLine();
        
        DFS(new Node(word), word.length());

        System.out.print(ans);
    }

    static void DFS (Node current, int depth)
    {
        if ( depth > max_depth )
        {
            max_depth = depth;
            ans = current.s;
        }

        for (int i=0; i<N; i++)
        {
            if (Is_Possible_To_Be_Next(current.s, word_arr[i]) == false || is_selected[i] == true )
                continue;
                
            is_selected[i] = true;
            current.next_list.add(new Node(word_arr[i]));
        }

        for (int i=0; i<current.next_list.size(); i++)
            DFS(current.next_list.get(i), depth+1);
    }

    static boolean Is_Possible_To_Be_Next (String current, String next)
    {
        int current_len = current.length();
        int next_len = next.length();
        int count = 0;

        if ( next_len != current_len + 1 )
            return false;

        for (int i=0; i<next_len; i++)
        {
            if ( next.charAt(i) == current.charAt(count) )
                count++;

            if ( count == current_len )
                break;
        }

        if ( count != current_len )
            return false;

        return true;
    }
}