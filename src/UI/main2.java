package UI;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *
 * @author LE BAO
 */

public class main2{

    private String algorithm;                
    
    private int speed;				  
    
    private int order;
    
    private ArrayComponent panel;       
    
    private Thread t;			
    
    private JFrame frame;
    
    public static boolean isExisted = false;
    
    private Integer[] values;
    
    public main2(String algorithm, int speed, int order, Integer[] values){
        
        this.algorithm = algorithm;
        
        this.speed = speed;
        
        this.order = order;
        
        this.frame = new JFrame("Sort Algorithm Simulator");
        
        this.frame.addWindowListener(new WindowAdapter(){
        
            @Override
            
            public void windowClosing(WindowEvent e){
                
                main2.isExisted = false;
                
            }
        });
        
        main2.isExisted = true;
        
        this.values = values;
        
    }

    public JFrame getFrame() {
        return frame;
    }
    
    

    public main2() {}

    public void initital() {
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        frame.setLocation(100, 50);
        
        frame.setResizable(false);
        
        try {

            Image image = ImageIO.read(getClass().getResource("/Images/icon.png"));

            frame.setIconImage(image);

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "Hello: " + ex.toString(), "Error", JOptionPane.WARNING_MESSAGE);

        }

        panel = new ArrayComponent();
        
        frame.add(panel, BorderLayout.CENTER);

        try {
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
        } catch (ClassNotFoundException e) {
            
            e.printStackTrace();
            
        } catch (InstantiationException e) {
            
            e.printStackTrace();
            
        } catch (IllegalAccessException e) {
            
            e.printStackTrace();
            
        } catch (UnsupportedLookAndFeelException e) {
            
            e.printStackTrace();
        }


        frame.setVisible(true);

        startSort();

    }

    private double max(Double[] arr){
        
        double max = Double.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            
            if(arr[i] > max){
                
                max = arr[i];
                
            }
            
        }
        
        return  max;
    }
    private void startSort() {

        if (t != null && t.isAlive()) {
            
            return;
            
        }
        
        frame.setSize(new Dimension(values.length * 30 + 7, 500));
        
        Runnable r = new Sorter(panel, values, algorithm, speed, order);
        
        t = new Thread(r);
        
        t.start();
    }

}
