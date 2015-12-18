/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;



import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.Collection;
import main.AllBicycles;




/**
 *
 * @author huma
 */
@RunWith(Parameterized.class)
public class ParameterizedFilter {
    
    private int min_currentCost;
    private int max_currentCost;
    private Boolean expectedResult;

    
    String bufIdArray[];
    String idArray[]; 
    
    AllBicycles b_Instance=AllBicycles.getInstance();
      
      //PARAMETRIZED CLASS     
        
                                                        //2.Используем «Фильтрацию» для выбора нужных нам товаров.
                                                        //-Параметры: Цена от 40035 до 80000 руб.    
    
    static int lowC=40035;
    static int maxC=80000;
   

    
    
   @Before
   public void initialize() {
      
   
     
        
    idArray=new String[b_Instance.getAllSize()];    
    bufIdArray=new String[b_Instance.getAllSize()];
    
    
    
    for(int i=0;i<idArray.length;i++)
    {idArray[i]=b_Instance.getItem(i+"").getId();};
    int count=0;
    for(int i=0;i<idArray.length;i++){            
        if(Integer.parseInt((b_Instance.getItem(Integer.parseInt(idArray[i])+"").getPrice())) >= lowC &&
        Integer.parseInt((b_Instance.getItem(Integer.parseInt(idArray[i])+"").getPrice())) <= maxC){
        idArray[count]=idArray[i];
        count++;        
        }}
        bufIdArray=idArray;
        idArray=new String[count];
        for(int i=0;i<count;i++){
        idArray[i]=bufIdArray[i];
        }
        
        
//        assertTrue(conditionMax<=maxC)
//        assertTrue(lowC<=conditionMin)
        
//        assertEqual(idArray[i] == PARAMETER);
      
   }
    
    
   public ParameterizedFilter(int min_currentCost,int max_currentCost,Boolean expectedResult) {
      this.min_currentCost = min_currentCost;
      this.max_currentCost = max_currentCost;
      this.expectedResult=expectedResult;
   }
    
   
   @Parameterized.Parameters
   public static Collection primeNumbers() {
      return Arrays.asList(new Object[][] {
         {lowC,maxC,true},
         { 90000,150000, true }             //FAILURE
      });
   }
   
   @Test
   public void testPrimeNumberChecker() {
      System.out.println("#ParameterizedFilter: START"); 
      for(int i=0;i<idArray.length;i++){ 
          
        int currentCost = Integer.parseInt(b_Instance.getItem(Integer.parseInt(idArray[i])+"").getPrice()); 
        System.out.println(i+":"+"Parameterized Number is : low cost: " + this.min_currentCost+"  , max cost : "+this.max_currentCost+". Current cost : "+ currentCost);
        assertEquals(expectedResult, (this.min_currentCost<=currentCost && currentCost<=this.max_currentCost));
      
      }
      System.out.println("#ParameterizedFilter: END");
      
   }
    
}
