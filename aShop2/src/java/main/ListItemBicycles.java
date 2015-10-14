package main;

import java.io.Serializable;
import java.util.ArrayList;
import main.Bicycle;

public class ListItemBicycles implements Serializable{
    
    ArrayList<Bicycle> list;
    
   public ListItemBicycles() {
        list = new ArrayList<Bicycle>();
    }
    
    public ArrayList<Bicycle> getList(){
        return list;
    }   
    
    public Bicycle get(int index){
        return list.get(index);
    }
        
    public int size(){
        return list.size();
    }
    
    public int getSomelistSize() { return this.list.size(); }
          
    public void clear() {
        list.clear();
    }
    
    public void add(Bicycle item) {
        list.add(item);
    }
    
    
    public void deleteItem(Bicycle item) {
        list.remove(item); 
    }
    
    public void remove(int id) {
        list.remove(id); 
    }
    
    public int getPriceAmount(){
        int result = 0;
        for (Bicycle item : list) {
            result += Integer.parseInt(item.getPrice());
        }
        return result;
    }
    
    
    
}
