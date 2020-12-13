/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahmoud.ahmed.abou.zithar17200193;

import java.util.Scanner;

import javax.swing.JOptionPane;

import net.objecthunter.exp4j.ExpressionBuilder;
//class to solve the numerical integration
 class numericalInt{
     
        double a,b,h;
        
        String equation=null;
        
         public numericalInt (double a,double b,double h,String equation){
             
        this.a=a;
        
        this.b=b;
        
        this.h=h;
        
        this.equation=equation;
        
         }
         //method to get the medpoint
      void clc_midpoint() throws Exception {
    
    double []x = new double[10];
    
       int count=0;
       //get x*(i)
     for(double i=a;i<b;i+=h){
         
            x[count]=(a+h)/2;
            
            a=a+(h*2);
            
             count++;
             
        }   //get f(x)
              double []f_of_x = new double[10];
              
        for(int i =0;i<count;i++){
            
            f_of_x[i] =clc(equation,x[i]);
            
        }
         
        //get the sum of the f(x) 
        double total =0;
        
        for(int i=0;i<count;i++){
            
            total=total + f_of_x[i];
            
        }
        double midpoint = h*total;
        //print the table
        for(int i=0;i<count;i++){
            
            System.out.println(x[i]);
            
            System.out.println(f_of_x[i]);
            
             System.out.println("===========");
             
            
        }
        // the final result
        System.out.println("The midpoint is: " + midpoint);
    
          
  }
      // method to getthe trapzoidial
         void clc_trapzoidial() throws Exception {
    
    double []x = new double[10];
       int count=0;
           //get x(i)
     for(double i=a;i<=b;i+=h){
         
            x[count]=a;
            
            a=a+h;
            
             count++;
             
        }
              double []f_of_x = new double[10];
                //get f(x)
        for(int i =0;i<=count;i++){
            
            f_of_x[i] =clc(equation,x[i]);
            
        }
        
       //get the sum of the f(x) and f(a)and f(b)
       double total =f_of_x[0];
       
        for(int i=1;i<count;i++){
            
            total=total + (2*f_of_x[i]);
            
        }

        total+=f_of_x[count];
        
        
        
        double trapzoidial = (h/2)*total;
       
        //print the table
        for(int i=0;i<count;i++){
            
            System.out.println(x[i]);
            
            System.out.println(f_of_x[i]);
            
             System.out.println("===========");
            
        }
        
        
        // the final result
        System.out.println("The trapzoidial is: " + trapzoidial);
    
  }
         //method to get the simpson 
            void clc_simpson() throws Exception {
                
   double []x = new double[10];
   
       int count=0;
         //get x(i)
     for(double i=a;i<=b;i+=h){
         
            x[count]=a;
            
            a=a+h;
            
             count++;
        }   //get f(x)
              double []f_of_x = new double[10];
              
        for(int i =0;i<=count;i++){
            
            f_of_x[i] =clc(equation,x[i]);
            
        }
        
        
       //get the sum of the f(x) and f(a)and f(b)
       double total =f_of_x[0];
       
        for(int i=1;i<count;i++)
            
        {
            if (f_of_x[i]%2==0){
                
                total=total + (2*f_of_x[i]); 
                
            }
            else{
                
                  total=total + (4*f_of_x[i]);
            }
  
        }
          total+=f_of_x[count];
        double simpson = (h/3)*total;
        
        //print the table
        for(int i=0;i<count;i++){
            
            System.out.println(x[i]);
            
            System.out.println(f_of_x[i]);
            
             System.out.println("===========");
            
        }
        
        
        // the final result
        System.out.println("The simpson is: " + simpson);
  }
            
            public static double clc(String eq, double value) throws Exception {
        
        net.objecthunter.exp4j.Expression e = new ExpressionBuilder(eq).variables("x").build().setVariable("x", value);
        
        double result = e.evaluate();
        
        return result; 
    }                 
    }
public class MahmoudAhmedAbouZithar17200193 {

   
    public static void main(String[] args) throws Exception {
        int iteration = 1;
        
        Scanner scn = new Scanner(System.in);
        //input of the user 
        String equation = JOptionPane.showInputDialog(null, "enter your equation  :");
        
        String number_A = JOptionPane.showInputDialog(null, "enter value of A :");
        
        double a = Double.parseDouble(number_A);
        
        String number_B = JOptionPane.showInputDialog(null, "enter value of B :");
        
        double b = Double.parseDouble(number_B);
        
        String fixed_width = JOptionPane.showInputDialog(null, "enter value of fixed width");
        
        double h = Double.parseDouble(fixed_width);
        
String the_type = JOptionPane.showInputDialog(null, "enter the type of method if it midpoint or trapzoidial or simpson like this (m,t,s)");
  
numericalInt slove = new numericalInt(a,b,h,equation);

if (the_type.equalsIgnoreCase("m")){
    
slove.clc_midpoint();

}
else if(the_type.equalsIgnoreCase("t")){
    
    slove.clc_trapzoidial();
    
    
}
else 
{
    slove.clc_simpson();
}
    }
  
}
