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
 * @author roba
 */
@XmlRootElement
public class Category {
    
    private String catName;
    private String title;
    private String desc;
    private String facts;
    private byte[] img;
    
    public Category() {
        
    }
    
    public Category(String cName, String title, String desc, String facts, byte[] img) {
        this.catName = cName;
        this.title = title;
        this.desc = desc;
        this.facts = facts;
        this.img = img;
    }
    
    public String getCatName() {
        return catName;
    }

    @XmlElement
    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    @XmlElement
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFacts() {
        return facts;
    }

    @XmlElement
    public void setFacts(String facts) {
        this.facts = facts;
    }

    public byte[] getImg() {
        return img;
    }

    @XmlElement
    public void setImg(byte[] img) {
        this.img = img;
    }
    
}
