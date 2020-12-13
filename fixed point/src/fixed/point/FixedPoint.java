package fixed.point;

import javax.swing.JOptionPane;
import net.objecthunter.exp4j.ExpressionBuilder;

public class FixedPoint {

    //the main funcation
    public static void main(String[] args) throws Exception {
        
        int iteration = 1;
        //get the main equation from user
        String equation = JOptionPane.showInputDialog(null, "enter your equation  :");
        //get the q(x)'s equation from user
        //String equationg=equation+"-x";
        String equationg = JOptionPane.showInputDialog(null,"enter the G(x)");
         //get the initial value from user 
        String numberA = JOptionPane.showInputDialog(null, "enter value of initial :");
         //turn it to double value 
        double a = Double.parseDouble(numberA);
         //get the tolerance from user
        String numberT = JOptionPane.showInputDialog(null, "enter value of tolerance");
        //turn it to double value
        double t = Double.parseDouble(numberT);
         //get the number of iterations from user
        String numberi = JOptionPane.showInputDialog(null, "enter number of iterations");
                //turn it to double value
        double iter = Double.parseDouble(numberi);
        // make the a vaule the x(i) value
        double x_initial = a;
       // create a flag to the conditions 
        boolean check = false;
   // send the g(equation) and the x(i) to the clc method
        double g_of_x = clc(equationg,a);
         //if conidition to the conditions of the fixed point
        if(Math.abs(g_of_x)<=t){
          
            check = true;
                //print the frist line of the the table
            System.out.println("  i: " + 1 + " x of i :" + x_initial + " g(x): " + g_of_x + "The condition: " + check);
            
            System.out.println("The value of root is : " + x_initial);
        }   else    {
            
System.out.println("  i: " + 1 + " x of i: " + x_initial + " g(x): " + g_of_x + "The condition is: " + check);

            int i=0;
            for(i=1;i<=iter;i++){
                //get the next g(x) and make the old one the x(i)
                    x_initial = g_of_x;
                    
                    g_of_x= clc(equation,x_initial);
                    //con.2 g(x)<t
                    if(Math.abs(g_of_x)<t){
                        
                        check = true;
                          //print the rest of the table 
                        System.out.println("  i: " + i + " x of i: " + x_initial + " g(x) : " + g_of_x + "The condition: " + check);
                        
                        System.out.println("The value of root is : " + x_initial);
                        
                        break;
                        
                    }   else    {
                        System.out.println(" i: " + i + " x of i: " + x_initial + "g(x): " + g_of_x + "The condition: " + check);
                        

                    }   }   }
        //con.1 max of iterations
        if(check==false){
            check = true;
              System.out.println("the last iterations is : ");
                        System.out.println("i: " + iter + "x of i: " + x_initial + "g(x): " + g_of_x + "The condition is : " + check);
                        
                        System.out.println("The value of root is: " + x_initial);
        }   }
    //the clc method to get any equation value
    public static double clc(String eq, double m) throws Exception {
        
        net.objecthunter.exp4j.Expression e = new ExpressionBuilder(eq).variables("x").build().setVariable("x", m);
        
        double result = e.evaluate();
        
        return result; 
        
    }   }