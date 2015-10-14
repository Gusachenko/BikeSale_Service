package main;


import java.util.ArrayList;

public class AllBicycles {
    
    private ArrayList<Bicycle> bikes = null;
    
    private static AllBicycles instance = null;
    
    private AllBicycles() {
        bikes = new ArrayList<Bicycle>();
        
        Bicycle bike0 = new Bicycle(0);
        Bicycle bike1 = new Bicycle(1);
        Bicycle bike2 = new Bicycle(2);
        Bicycle bike3 = new Bicycle(3);
        Bicycle bike4 = new Bicycle(4);
            
            bikes.add(bike0);
            bikes.add(bike1);
            bikes.add(bike2);
            bikes.add(bike3);
            bikes.add(bike4);
    }
    
    public Bicycle getItem(String id) {
        for (Bicycle item : bikes) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        
        return null;
    }
    
    public static AllBicycles getInstance() {
        if (instance == null) {
            instance = new AllBicycles();
        }
        
        return instance;
    }
}



