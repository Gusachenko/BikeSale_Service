/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author huma
 */
public class Test_VerifyClass2 {
    
    String str= "Junit is working fine";
    MyUtil mUtil=new MyUtil("Junit is working fine");
    
    @Test
   public void testAddSecondMessage() {
      
      assertEquals(str,mUtil.printSecondMessage());
   }
    
    
}
