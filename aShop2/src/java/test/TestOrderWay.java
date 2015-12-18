/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import dbase.TOrdering;
import dbase.WorkingBas;
import java.util.List;
import main.AllBicycles;
import main.Bicycle;
import main.ListItemBicycles;


import org.junit.Test;
import static org.junit.Assert.assertEquals;






/**
 *
 * @author huma
 */
public class TestOrderWay {
    
    AllBicycles b_Instance=AllBicycles.getInstance();  //1. Запускаем браузер и переходим по на главную страницу.
    // проверка: соответствует ли кол-во товаров, кол-ву в БД  
    
    @Test
    public void testDB_Amount() {
       System.out.println("#testDB_Amount");
       assertEquals(6,b_Instance.getAllSize());
    }
    
    
    
    
    //3.Переходим на карточку товаров.
    Bicycle b_item=AllBicycles.getInstance().getItem("2");
    //Проверка на отображение выбранного нами товара        
    //4.Нажимаем на кнопку «Добавить в корзину», товар добавляется в корзину. Переходим в корзину.
    ListItemBicycles list=new ListItemBicycles(b_item);        
       
    @Test//Проверка на добавление товара в "корзину"
    public void test_ListItemBicycles() {
       System.out.println("#test_ListItemBicycles");
       
//       list.add(b_item);
       
       
       assertEquals("2",list.get(0).getId());
    }
    
    
    @Test//Проверка на добавление товара в "корзину"
    public void test_FinalOrderInformation() {
       System.out.println("#testDB_FinalOrderInformation");
       
                                                       //5.После нажатия кнопки «Заказ» на странице «Корзина» либо в кнопки «Заказ» в шапке сайта, происходит процедура оформаления заказа.
                                                        //-указываем адрес доставки товара;
        String userName_ = "testUser";
        String shop_="Санкт-Петербург, Торжковская 15";


//        for(int i=0; i<=list.size();i++){
        String productTitle_=list.get(0).getTitle();      
        int  cost_=Integer.parseInt(list.get(0).getPrice());
        WorkingBas.add_Order_InDB(userName_,productTitle_,shop_,cost_);
//        }
        
        
        //6.Страница «Оформление заказа»
                                                        //-вывод всей информации о сделанном заказе.
            //Проверка на корректность введённой ранее информации
        List<TOrdering> listUserItems=null;
        listUserItems=WorkingBas.getUser_Order_ElementDB(userName_);

//        listUserItems.get(i).getProductTitle();
//        listUserItems.get(i).getIssueDate();
//        listUserItems.get(i).getShop();
//        listUserItems.get(i).getCost();
//        
       
       
       
        assertEquals(list.get(0).getTitle(),listUserItems.get(0).getProductTitle());
        assertEquals("CUSTOM ERROR",listUserItems.get(0).getProductTitle());
    }
    
      
}
