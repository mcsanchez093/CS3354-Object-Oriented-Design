/*****************************
 * Author: Maria Sanchez
 * CS3354 Summer II
 *****************************/

import java.util.*;
import java.io.*;
import javax.swing.*;

public class CollatzTree {
    
    public static ArrayList<Integer> forward = new ArrayList<Integer>();
    public static ArrayList<Integer> backward = new ArrayList<Integer>();
    public static JFrame f = new JFrame();
    
    /**********************************************
     * Backward chaining sequence
     * If n = even then n/2
     * Else n * 3 + 1
     **********************************************/
    public static void backward(int n, int l)
    {
        int count = 0;
        while (n != 1)
        {
            count++;
            if(count > l)
            {
                break;
            }
            n = (n % 2 == 0) ? n / 2 : n * 3 + 1;
            backward.add(n);
        }
    }
    
    /**********************************************
     * Forward chaining sequence
     * If n=even AND ((n-1)mod3=0 then {2xn,(n-1)/3}
     * Else {2 x n}
     **********************************************/
    public static void forward(int n, int l)
    {
        int count = 0;
        while (n != 1)
        {
            count++;
            if(count > l)
            {
                break;
            }
            n = ((n%2==0) && ((n-1)%3 == 0)) ? (n-1)/3: 2*n;
            forward.add(n);
        }
        //else
        //forward.add(2*n);
      
    }
    
    public static void main(String args[]) throws FileNotFoundException
    {
        int n, l;
        n = Integer.parseInt(JOptionPane.showInputDialog(f,"Enter n: "));
        l = Integer.parseInt(JOptionPane.showInputDialog(f,"Enter max iterations: "));
        backward(n,l);
        forward(n,l);
        Collections.sort(forward);
        Collections.sort(backward);
        
        PrintWriter NewFile = new PrintWriter("CollatzTree.txt");
        //Prints forward and backward iterations into "CollatzTree.txt"
        NewFile.println(forward);
        NewFile.println(backward);
        NewFile.flush();
        NewFile.close();
        
        JOptionPane.showMessageDialog(f, "Forward data: "+forward.toString()+"\n Backward data: "+backward.toString());
    }
}

