/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author huma
 */
public class MyUtil {
    
    private String message;

   //Constructor
   //@param message to be printed
   public MyUtil(String message){
      this.message = message;
   }
   
   public MyUtil(){
      
   }
      
   // prints the message
   public String printMessage(){
      System.out.println(message);
      return message;
   }
   
   public String printSecondMessage(){
       this.message=message+" SecondMessage";
       return message;
   }
   
   
   public Boolean validate(final Integer primeNumber) {
      for (int i = 2; i < (primeNumber / 2); i++) {
         if (primeNumber % i == 0) {
            return false;
         }
      }
      return true;
   }
   
   
   
   
   ////////////////////////////////////////////////////////
   //TEST ORDER WAY
   
   
   
    
}
