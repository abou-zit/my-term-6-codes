
package mahmoud.ahmed.gamal.abou.zithr17200193.pkg3;


import java.util.Scanner;
import javax.swing.JOptionPane;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MahmoudAhmedGamalAbouZithr172001933 {

    public static void main(String[] args) throws Exception {
        
        int iteration = 1;
        
        Scanner scn = new Scanner(System.in);
        
        String equation = JOptionPane.showInputDialog(null, "enter your equation  :");
        
         String devequation = JOptionPane.showInputDialog(null, "enter your equation's Differentiation :");
         
        String number_A = JOptionPane.showInputDialog(null, "enter value of initial from :");
        
        double a = Double.parseDouble(number_A);
        
        String number_B = JOptionPane.showInputDialog(null, "to:");
        
        double b = Double.parseDouble(number_B);
        
        String number_tol = JOptionPane.showInputDialog(null, "enter value of tolerance");
        
        double tol = Double.parseDouble(number_tol);
        
        double n = Math.log((b - a) / tol) / Math.log(2);
        
        double f_of_a = clc(equation, a);
        
        double f_of_b = clc(equation, b);
        
        int i;
        
        int j;
        
            int row = (int)n;
            
            int colm = 5;
            
         
            
               double x_of_i=a;
            
            for (i = 1; i <= row; i++) {
                
                for (j = 1; j <= colm; j++) {
                    
                 
                    
                    double f_of_x = clc(equation, x_of_i);
                    
                    double devF_of_x= clcdev(devequation,x_of_i);
                    
                    boolean check = false;
                    
                    if (Math.abs(f_of_x) <= tol) {
                        
                        check = true;
                        
                        System.out.println(i+"| "+ "x(i) = " + x_of_i +" f(x) = " + f_of_x + " f'(x) = " + devF_of_x + " condition = " + check);
                        
                        JOptionPane.showMessageDialog(null, "The root is  " + x_of_i);
                        
                        break;
                        
                    } 
                    
                    else 
                        
                    {

                    x_of_i=x_of_i-f_of_x/devF_of_x;
                        
                             f_of_x = clc(equation, x_of_i);
                             
                     devF_of_x= clcdev(devequation,x_of_i);
                     
                      
                        
                        System.out.println(i+"x(i) = " + x_of_i +" f(x) = " + f_of_x + " f'(x) = " + devF_of_x + " condition = " + check);                     
                     
                                     }       }}            }
    
    public static double clc(String eq, double m) throws Exception {
        
        net.objecthunter.exp4j.Expression e = new ExpressionBuilder(eq).variables("x").build().setVariable("x", m);
        
        double result = e.evaluate();
        
        return result; 
        
    }
    public static double clcdev (String eq, double m) throws Exception {
        
        net.objecthunter.exp4j.Expression e = new ExpressionBuilder(eq).variables("x").build().setVariable("x", m);
        
         double result = e.evaluate();
         
        return result; 
        
    }               }
