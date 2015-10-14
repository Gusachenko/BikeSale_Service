package main;


import java.io.Serializable;

import java.util.Comparator;

public class Bicycle implements BicyclesInf,Serializable {
    String id;
    String tittle;
    String imageOfBicycle;
    String imageOfBicycle2;
    String brand,style,frame,wheels,brakes,fork,speeds,weight;
    String price;
    

    
    public Bicycle(String id_,String tittle_,String imageOfBicycle_,String imageOfBicycle2_,String brand_,String style_,String frame_,String wheels_,String brakes_
                    ,String fork_,String speeds_,String weight_,String price_){
        id=id_;
        tittle=tittle_;
        imageOfBicycle=imageOfBicycle_;
        imageOfBicycle2=imageOfBicycle2_;
        brand=brand_;
        style=style_;
        frame=frame_;
        wheels=wheels_;
        brakes=brakes_;
        fork=fork_;
        speeds=speeds_;
        weight=weight_;
        price=price_;
    }
    
    
    
    public Bicycle(int iter){
        
        XmlStreamReader reader = new XmlStreamReader();
                       try {                  
                          reader.readXml();
                       } catch (Exception e) {
                           // TODO: Add catch code
                           e.printStackTrace();
                       }

        id=reader.getId(iter);        
        tittle=reader.getTitle(iter);
        imageOfBicycle=reader.getImg(iter);
        imageOfBicycle2=reader.getImg2(iter);
        brand=reader.getBrand(iter);
        style=reader.getStyle(iter);
        frame=reader.getFrame(iter);
        wheels=reader.getWheels(iter);
        brakes=reader.getBrakes(iter);
        fork=reader.getFork(iter);
        speeds=reader.getSpeeds(iter);
        weight=reader.getWeight(iter);
        price=reader.getPrice(iter);
    }
    
    public Bicycle(){}

    @Override
    public String getId() {
        // TODO Implement this method
        return id;
    }

    @Override
    public String getTitle() {
        // TODO Implement this method
        return tittle;
    }

    @Override
    public String getImg() {
        // TODO Implement this method
        return this.imageOfBicycle;
    }
    
    @Override
    public String getImg2() {
        // TODO Implement this method
        return imageOfBicycle2;
    }
    
    @Override
    public String getBrand() {
        // TODO Implement this method
        return brand;
    }
    
    @Override
    public String getStyle() {
        // TODO Implement this method
        return style;
    }

    @Override
    public String getFrame() {
        // TODO Implement this method
        return frame;
    }

    @Override
    public String getWheels() {
        // TODO Implement this method
        return wheels;
    }

    @Override
    public String getBrakes() {
        // TODO Implement this method
        return brakes;
    }

    @Override
    public String getFork() {
        // TODO Implement this method
        return fork;
    }

    @Override
    public String getSpeeds() {
        // TODO Implement this method
        return speeds;
    }

    @Override
    public String getWeight() {
        // TODO Implement this method
        return weight;
    }

    @Override
    public String getPrice() {
        // TODO Implement this method
        return price;
    }






    @Override
    public void setId(String valueId) {
        // TODO Implement this method
        this.id=valueId;
    }

    @Override
    public void setTitle(String valueTittle) {
        // TODO Implement this method
        this.tittle=valueTittle;
    }

    @Override
    public void setImg(String valueImg) {
        // TODO Implement this method
        this.imageOfBicycle=valueImg;
    }
    
    @Override
    public void setImg2(String valueImg) {
        // TODO Implement this method
        this.imageOfBicycle2=valueImg;
    }
    
    @Override
    public void setBrand(String valueBrand) {
        // TODO Implement this method
        this.brand=valueBrand;
    }

    @Override
    public void setStyle(String valueStyle) {
        // TODO Implement this method
        this.style=valueStyle;
    }

    @Override
    public void setFrame(String valueFrame) {
        // TODO Implement this method
        this.frame=valueFrame;
    }

    @Override
    public void setWheels(String valueWheels) {
        // TODO Implement this method
        this.wheels=valueWheels;
    }

    @Override
    public void setBrakes(String valueBrakes) {
        // TODO Implement this method
        this.brakes=valueBrakes;
    }

    @Override
    public void setFork(String valueFork) {
        // TODO Implement this method
        this.fork=valueFork;
    }

    @Override
    public void setSpeeds(String valueSpeeds) {
        // TODO Implement this method
        this.speeds=valueSpeeds;
    }

    @Override
    public void setWeight(String valueWeight) {
        // TODO Implement this method
        this.weight=valueWeight;
    }

    @Override
    public void setPrice(String valuePrice) {
        // TODO Implement this method
        this.price=valuePrice;
    }

}
