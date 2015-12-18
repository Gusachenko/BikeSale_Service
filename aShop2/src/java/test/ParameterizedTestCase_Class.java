/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import org.junit.runner.RunWith;

/**
 *
 * @author huma
 */
@RunWith(Parameterized.class)
public class ParameterizedTestCase_Class {
    
    
    private Integer inputNumber;
    private Boolean expectedResult;
    private MyUtil myUtil;
    
    
    @Before
   public void initialize() {
      myUtil = new MyUtil();
   }
    
    
   public ParameterizedTestCase_Class(Integer inputNumber, 
      Boolean expectedResult) {
      this.inputNumber = inputNumber;
      this.expectedResult = expectedResult;
   }
    
   
   @Parameterized.Parameters
   public static Collection primeNumbers() {
      return Arrays.asList(new Object[][] {
         { 2, false },
         { 6, false },
         { 19, true },
         { 22, false },
         { 23, true }
      });
   }
   
   @Test
   public void testPrimeNumberChecker() {
      System.out.println("Parameterized Number is : " + inputNumber);
      assertEquals(expectedResult, myUtil.validate(inputNumber));
   }
   
   
   
    
}
