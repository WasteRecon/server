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
public class Image {
    private String name;
    private byte[] img;
    private String catName;

    public Image() {
    }

    public Image(String name, byte[] img, String catName) {
        this.name = name;
        this.img = img;
        this.catName = catName;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the img
     */
    public byte[] getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    @XmlElement
    public void setImg(byte[] img) {
        this.img = img;
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
}
