package main;


import dbase.TGoods;
import dbase.WorkingBas;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllBicycles {
    
    
    ArrayList<String> uniqueBrand=new ArrayList();
    public int uniqueBrandCount;
    ArrayList<String> uniqueStyle=new ArrayList();
    public int uniqueStyleCount;
    ArrayList<String> uniqueWheels=new ArrayList();
    public int uniqueWheelsCount;
    
    UniqueTo brUniqueTo;
    UniqueTo stUniqueTo;
    UniqueTo whUniqueTo;
    
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
                
                
            uniqueWheels.add(goodsItem.getWheels());
            uniqueBrand.add(goodsItem.getBrand());
            uniqueStyle.add(goodsItem.getStyle());
                
                
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
        
        
        
        
         
            
       
        
        brUniqueTo=removeDuplicates(uniqueBrand);
        stUniqueTo=removeDuplicates(uniqueStyle);
        whUniqueTo=removeDuplicates(uniqueWheels);
       
        
//        uniqueBrand = removeDuplicates(uniqueBrand);
        uniqueBrandCount=brUniqueTo.uniqueCounts;
        uniqueStyleCount=brUniqueTo.uniqueCounts; 
//        uniqueWheels = removeDuplicates(uniqueWheels);
        uniqueWheelsCount=whUniqueTo.uniqueCounts;
        
        
        
        
        
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
    public static AllBicycles instanceUpdate() {

            instance = new AllBicycles();
        
        return instance;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    
    
    public String getUniqueBrand(int iter) {
        
        return brUniqueTo.list.get(iter);
    }
    public String getUniqueStyle(int iter) {
        
        return stUniqueTo.list.get(iter);
    }
    
    public String getUniqueWheels(int iter) {
        return whUniqueTo.list.get(iter);
    }
    
    
    public class UniqueTo{
    ArrayList<String> list=new ArrayList();
    public int uniqueCounts;
    public UniqueTo(ArrayList<String> list_){
        list=list_;
        uniqueCounts=list.size();
    }
    
}

    public UniqueTo removeDuplicates(ArrayList<String> list) {

            // Store unique items in result.
            ArrayList<String> result = new ArrayList<String>();

            // Record encountered Strings in HashSet.
            HashSet<String> set = new HashSet<String>();

            // Loop over argument list.
            for (String item : list) {

                // If String is not in set, add it to the list and the set.
                if (!set.contains(item)) {
                    result.add(item);
                    set.add(item);
                }
            }
            return new UniqueTo(result);
        }
    
    
    
}



