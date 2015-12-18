/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 *
 * @author huma
 */
public class Test_VerifyClass {
    
    
    String str= "Junit is working fine";
    MyUtil mUtil=new MyUtil("Junit is working fine");
    
    @Test
   public void testAdd() {
      
      assertEquals(str,mUtil.printMessage());
   }
    
}
