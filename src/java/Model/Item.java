/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author congthanhptnk
 */
@XmlRootElement
public class Item {
    private String catName;
    private String shape;
    private String material;
    
    public Item(){
        
    }
    
    public Item(String catName, String shape, String material){
        this.catName = catName;
        this.shape = shape;
        this.material = material;
    }

    /**
     * @return the catName
     */
    public String getCatName() {
        return catName;
    }

    /**
     * @param catName the catName to set
     */
    @XmlElement
    public void setCatName(String catName) {
        this.catName = catName;
    }

    /**
     * @return the shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * @param shape the shape to set
     */
    @XmlElement
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * @return the material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    @XmlElement
    public void setMaterial(String material) {
        this.material = material;
    }
}
