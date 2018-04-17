/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congthanhptnk
 */
public class GlobalModel {
    private final List<Category> categories = new ArrayList();
    private final List<Image> images = new ArrayList();
    private final List<Item> items = new ArrayList();
    
    private GlobalModel() {
    }
    
    public static GlobalModel getInstance() {
        return GlobalModelHolder.INSTANCE;
    }
    
    private static class GlobalModelHolder {

        private static final GlobalModel INSTANCE = new GlobalModel();
    }
    
    public List<Image> getAllImages(){
        return this.images;
    }
    
    public void addImage(Image image){
        this.images.add(image);
    }
}
