import java.io.*;
import java.util.*;

public class G1_27315
{
    static class Problem
    {
        int idea_level;
        int implementation_level;
        int data;
        int editorial;

        Problem (int idea_level, int implementation_level, int data, int editorial)
        {
            this.idea_level = idea_level;
            this.implementation_level = implementation_level;
            this.data = data;
            this.editorial = editorial;
        }
    }
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        long wa_count = 0;

        ArrayList<Problem> problem_list = new ArrayList<>();

        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(input.readLine());

            int idea_level = Integer.parseInt(st.nextToken());
            int implementation_level = Integer.parseInt(st.nextToken());
            int data = Integer.parseInt(st.nextToken());
            int editorial = Integer.parseInt(st.nextToken());
            problem_list.add( new Problem(idea_level, implementation_level, data, editorial) );
        }

        st = new StringTokenizer(input.readLine());

        int hanbyul_idea_level = Integer.parseInt(st.nextToken());
        int hanbyul_implementation_level = Integer.parseInt(st.nextToken());

        PriorityQueue<Problem> solvable = new PriorityQueue<>( new Comparator<Problem>() {
            @Override
            public int compare(Problem p1, Problem p2) {
                if ( p1.data != p2.data )
                    return -(p1.data - p2.data);

                return p1.implementation_level - p2.implementation_level;
            }
        } );

        PriorityQueue<Problem> unsolvable = new PriorityQueue<>( new Comparator<Problem>() {
            @Override
            public int compare(Problem p1, Problem p2) {
                if ( p1.editorial != p2.editorial )
                {
                    int flag = p1.idea_level*(p2.editorial + 1) - p2.idea_level*(p1.editorial + 1);

                    if ( flag != 0 )
                        return flag;
                }
                else if ( p1.idea_level != p2.idea_level )
                    return p1.idea_level - p2.idea_level;

                return p1.implementation_level - p2.implementation_level;
            }
        } );

        for (int i=0; i<problem_list.size(); i++)
        {
            Problem current_problem = problem_list.get(i);

            if ( current_problem.editorial == 1 )
            {
                if ( 2*hanbyul_idea_level >= current_problem.idea_level )
                {
                    current_problem.idea_level /= 2;
                    current_problem.implementation_level /= 2;
                    solvable.add(current_problem);
                }
                else
                    unsolvable.add(current_problem);
            }
            else
            {
                if ( hanbyul_idea_level >= current_problem.idea_level )
                    solvable.add(current_problem);
                else
                    unsolvable.add(current_problem);
            }
        }

        while (true)
        {
            if ( solvable.isEmpty() == true )
                break;

            Problem current_problem = solvable.poll();
            int implementation_level_level_gap = current_problem.implementation_level - hanbyul_implementation_level;

            if ( current_problem.data == 0 && implementation_level_level_gap > 0 )
                wa_count += implementation_level_level_gap;
            
            count++;
            hanbyul_idea_level++;
            hanbyul_implementation_level++;

            if ( count == M )
                break;
            
            while (true)
            {
                if ( unsolvable.isEmpty() == false  )
                {
                    Problem next_problem = unsolvable.peek();

                    if ( next_problem.editorial == 1 )
                    {
                        if ( 2*hanbyul_idea_level >= next_problem.idea_level )
                        {
                            next_problem.idea_level /= 2;
                            next_problem.implementation_level /= 2;
                            solvable.add( unsolvable.poll() );
                        }
                        else
                            break;
                    }
                    else
                    {
                        if ( hanbyul_idea_level >= next_problem.idea_level )
                            solvable.add( unsolvable.poll() );
                        else
                            break;
                    }
                }
                else
                    break;
            }
        }

        if ( count == M )
            System.out.print(wa_count);
        else
            System.out.print(-1);
    }
}