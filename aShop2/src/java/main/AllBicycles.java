package main;


import dbase.TGoods;
import dbase.WorkingBas;
import java.util.ArrayList;
import java.util.List;

public class AllBicycles {
    
    private ArrayList<Bicycle> bikes = null;
    
    private static AllBicycles instance = null;
    
    private AllBicycles() {
        bikes = new ArrayList<Bicycle>();
        
        List goodsList=WorkingBas.get_GoodsList_InDB();
        TGoods goodsItem=null;
        
        if(goodsList!=null){
            
            for(int i=0;i<goodsList.size();i++){
                goodsItem=(TGoods) goodsList.get(i);
                bikes.add(new Bicycle(goodsItem.getId().toString(),goodsItem.getTitle(),
                goodsItem.getImg1(),goodsItem.getImg2(),goodsItem.getBrand(),goodsItem.getStyle()
                ,goodsItem.getFrame(),goodsItem.getWheels(),goodsItem.getBrakes(),goodsItem.getFork()
                ,goodsItem.getSpeeds(),goodsItem.getWeight(),goodsItem.getPrice()));
                
            }
            
        }
        
//        Bicycle bike0 = new Bicycle(0);
//        Bicycle bike1 = new Bicycle(1);
//        Bicycle bike2 = new Bicycle(2);
//        Bicycle bike3 = new Bicycle(3);
//        Bicycle bike4 = new Bicycle(4);
//            
//            bikes.add(bike0);
//            bikes.add(bike1);
//            bikes.add(bike2);
//            bikes.add(bike3);
//            bikes.add(bike4);
    }
    
    public Bicycle getItem(String id) {
        for (Bicycle item : bikes) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        
        return null;
    }
    
    public int getAllSize(){       
        return bikes.size();
    }
    
    public static AllBicycles getInstance() {
        if (instance == null) {
            instance = new AllBicycles();
        }
        
        return instance;
    }
}



