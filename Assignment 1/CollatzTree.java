/*****************************
 * Author: Maria Sanchez
 * CS3354 Summer II
 *****************************/

import java.util.*;
import java.io.*; //imports all  classes

public class CollatzTree
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("    Collatz Tree");
        System.out.println("--------------------");
        System.out.println(" ");
        
        int n = 8; //Starting integer
        Queue<Integer> q= new LinkedList<>();
        q.add(n);
        int iterations = 20; //20 iterations after 8
        
        while(iterations > 0)
        {
            
            int j = q.remove();// Remove from queue
            System.out.println("Removed head: " + j);
            
            int[] succ = Successor(j);
            for (int i = 0; i < succ.length; i++)
            {
                q.add(succ[i]);
            }
            PrintWriter NewFile = new PrintWriter("CollatzTree.txt");
            NewFile.println(n);
            iterations--;
            NewFile.flush();
            NewFile.close();
        }
    }
    //Calculations
    public static int[] Successor(int n)
    {
        assert (n > 4);
        if (n % 2 == 0 && (n - 1) % 3 == 0)
        {
            int[] a = {2 * n, (n - 1) / 3};
            return a;
        }
        else
        {
            int[] a = {2 * n};
            return a;
        }
        
    }
    
}

