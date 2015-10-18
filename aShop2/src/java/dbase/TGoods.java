/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbase;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author huma
 */
public class TGoods implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String img1;
    private String img2;
    private String brand;
    private String style;
    private String frame;
    private String wheels;
    private String brakes;
    private String fork;
    private String speeds;
    private String weight;
    private String price;

    public TGoods() {
    }
    
    public TGoods(int id_,String title_,String img1_,String img2_,String brand_
    ,String style_,String frame_,String wheels_,String brakes_,String fork_,
    String speeds_,String weight_,String price_) {
        
        id=id_;
        title=title_;
        img1=img1_;
        img2=img2_;
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

    public TGoods(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public String getBrakes() {
        return brakes;
    }

    public void setBrakes(String brakes) {
        this.brakes = brakes;
    }

    public String getFork() {
        return fork;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }

    public String getSpeeds() {
        return speeds;
    }

    public void setSpeeds(String speeds) {
        this.speeds = speeds;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TGoods)) {
            return false;
        }
        TGoods other = (TGoods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    
}
