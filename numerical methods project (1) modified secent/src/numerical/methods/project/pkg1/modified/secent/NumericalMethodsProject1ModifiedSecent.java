/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.methods.project.pkg1.modified.secent;

import java.util.Scanner;
import javax.swing.JOptionPane;
                                                  
import  net.objecthunter.exp4j.ExpressionBuilder;

public class NumericalMethodsProject1ModifiedSecent {

    public static void main(String[] args) throws Exception {
        
        int iteration = 1;
        
        Scanner scn = new Scanner(System.in);
        
        String equation = JOptionPane.showInputDialog(null, "enter your equation  :");
        
        String number_A = JOptionPane.showInputDialog(null, "enter value of A :");
        
        double a = Double.parseDouble(number_A);
        
        String number_B = JOptionPane.showInputDialog(null, "enter value of B :");
        
        double b = Double.parseDouble(number_B);
        
        String number_tol = JOptionPane.showInputDialog(null, "enter value of tolerance");
        
        double tol = Double.parseDouble(number_tol);
        
        double n = Math.log((b - a) / tol) / Math.log(2);
        
        double f_of_a = clc(equation, a);
        
        double f_of_b = clc(equation, b);
        
        int i;
        
        int j;
        
        if (f_of_a * f_of_b > 0) {
            
            JOptionPane.showMessageDialog(null, "Has NO Root");
            
        } 
        else
        {
            
            int row = (int)n;
            
            int colm = 8;
            
            double[][] arr = new double[row][colm];
            
            for (i = 1; i <= row; i++) {
                
                for (j = 1; j <= colm; j++) {
                    
                    double c =  b-(f_of_b*((b-a)/(f_of_b-f_of_a)));
                    
                    double f_of_c = clc(equation, c);
                    
                    boolean check = false;
                    
                    if (Math.abs(f_of_c) <= tol) {
                        
                        check = true;
                        
                        System.out.println(i+"a = " + a +" b = " + b + " c = " + c + " f(a) = " + f_of_a + " f(b) = " + f_of_b + " f(c) = " + f_of_c + " condition = " + check);
                        
                        JOptionPane.showMessageDialog(null, "The root is  " + c);
                        
                        break;
                        
                    }
                    
                    else
                        
                    {
                        
                        if (f_of_a * f_of_c < 0) {

                            b = c;
                            
                            f_of_b = f_of_c;
                            
                          c =  b-(f_of_b*((b-a)/(f_of_b-f_of_a)));
                          
                            f_of_c = clc(equation, c);
                            
                                            System.out.println(i+"a = " + a +" b = " + b + " c = " + c + " f(a) = " + f_of_a + " f(b) = " + f_of_b + " f(c) = " + f_of_c + " condition = " + check);
                                            
} 
                        else {
                            a = c;
                            
                            f_of_a = f_of_c;
                            
                          c =  b-(f_of_b*((b-a)/(f_of_b-f_of_a)));
                         
                            f_of_c = clc(equation, c);  
                            
                        System.out.println(i+"a = " + a +" b = " + b + " c = " + c + " f(a) = " + f_of_a + " f(b) = " + f_of_b + " f(c) = " + f_of_c + " condition = " + check);
                        
                        
                        }   }       }}        }    }
    
    public static double clc(String eq, double m) throws Exception {
        
        net.objecthunter.exp4j.Expression e = new ExpressionBuilder(eq).variables("x").build().setVariable("x", m);
        
        double result = e.evaluate();
        
        return result; 
    }
}
