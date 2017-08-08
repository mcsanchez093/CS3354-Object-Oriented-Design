/*****************************
 * Author: Maria Sanchez
 * CS3354 Summer II
 *****************************/

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JMenu;


public class TwinUI {
    
    public JFrame frame;
    public JTextField input;
    public JTextField output;
    
    public static TwinPrime tp;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        tp = new TwinPrime();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TwinUI window = new TwinUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the application.
     */
    public TwinUI() {
        initialize();
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JMenu mnNewMenu = new JMenu("CSV Files");
        mnNewMenu.setBounds(-8, 16, 147, 31);
        frame.getContentPane().add(mnNewMenu);
        
        JMenuItem m1 = new JMenuItem("Input.csv");
        JMenuItem m2 = new JMenuItem("Output.csv");
        
        mnNewMenu.add(m1);
        mnNewMenu.add(m2);
        JLabel lblNewLabel = new JLabel("INPUT  :");
        lblNewLabel.setBounds(15, 71, 113, 32);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("OUTPUT :");
        lblNewLabel_1.setBounds(15, 138, 113, 32);
        frame.getContentPane().add(lblNewLabel_1);
        
        input = new JTextField();
        input.setBounds(208, 74, 146, 26);
        frame.getContentPane().add(input);
        input.setColumns(10);
        
        output = new JTextField();
        output.setBounds(208, 141, 146, 26);
        frame.getContentPane().add(output);
        output.setColumns(10);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(15, 186, 398, 2);
        frame.getContentPane().add(separator);
        
        
        JButton btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBounds(62, 199, 115, 29);
        frame.getContentPane().add(btnSubmit);
        
        btnSubmit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String in = input.getText();
                if(in != null){
                    int n = Integer.parseInt(in);
                    System.out.println(n);
                    int res = tp.primality(n);
                    String out = tp.printResult(n, res);
                    output.setText(out);
                    tp.writeToOutCSV(n, res);
                }
            }
        });
        
        JButton btnExit = new JButton("EXIT");
        btnExit.setBounds(239, 199, 115, 29);
        frame.getContentPane().add(btnExit);
        
        btnExit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
