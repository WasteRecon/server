/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import Model.CategoriesData;

/**
 *
 * @author congthanhptnk
 */
public class GlobalModel {
    private CategoriesData cd = new CategoriesData();
    
    private final List<Category> categories = new ArrayList();
    private final List<Image> images = new ArrayList();
    private final List<Item> items;
    
    
    
    private GlobalModel() {
        //items.add(new Item("plasticCup", "cup", "plastic"));
        //items.add(new Item("lightBulb", "lightbulb", "glass"));
        items = cd.populateCategories();
        System.out.println("Is this working");
    }
    
    public static GlobalModel getInstance() {
        return GlobalModelHolder.INSTANCE;
    }
    
    private static class GlobalModelHolder {

        private static final GlobalModel INSTANCE = new GlobalModel();
    }
    
    //MARK: Image
    public String getAllImages(){
        JSONArray jsonArray = new JSONArray();
        
        for(Image i: this.images){
            String base64Image = Base64.getEncoder().encodeToString(i.getImg());
            JSONObject obj = new JSONObject();
            obj.put("name", i.getName());
            obj.put("img", base64Image);
            obj.put("catName", i.getCatName());
            jsonArray.add(obj);
        }
        return jsonArray.toJSONString();
    }
    
    public void addImage(Image image){
        this.images.add(image);
    }
    
    public String getImagesOfCategory(String catName){
        List<Image> imgCat = new ArrayList();
        for(Image img: this.images){
            if(img.getCatName().equals(catName)){
                imgCat.add(img);
            }
        }
        
        JSONArray jsonArray = new JSONArray();
        
        for (Image i: imgCat) {
            String base64Image = Base64.getEncoder().encodeToString(i.getImg());
            JSONObject obj = new JSONObject();
            obj.put("name", i.getName());
            obj.put("img", base64Image);
            obj.put("catName", i.getCatName());
            jsonArray.add(obj);
        }
        return jsonArray.toJSONString();
    }
    
    //MARK: Category
    public String getAllCategories(){
        JSONArray jsonArray = new JSONArray();
        
        for(Category c: this.categories){
            String base64Image = Base64.getEncoder().encodeToString(c.getImg());
            JSONObject obj = new JSONObject();
            obj.put("catName", c.getCatName());
            obj.put("img", base64Image);
            obj.put("title", c.getTitle());
            obj.put("description", c.getDesc());
            obj.put("facts", c.getFacts());
            jsonArray.add(obj);
        }
        return jsonArray.toJSONString();
    }
    
    public String getSingleCategory(String catName){
        
        JSONArray jsonArray = new JSONArray();
        
        for(Category c: this.categories){
            if(c.getCatName().equals(catName)){
                String base64Image = Base64.getEncoder().encodeToString(c.getImg());
                JSONObject obj = new JSONObject();
                obj.put("catName", c.getCatName());
                obj.put("img", base64Image);
                obj.put("title", c.getTitle());
                obj.put("description", c.getDesc());
                obj.put("facts", c.getFacts());
                jsonArray.add(obj);
            }
        }
        return jsonArray.toJSONString();
    }
    
    //MARK: Item 
    public void addItem(Item item){
        this.items.add(item);
    }
    
    public String getCatNameFromItem(String shape, String material){
        String catName = "";
        for (Item combination : this.items) {
            if (combination.getShape().equals(shape) && combination.getMaterial().equals(material)) {
                catName = combination.getCatName();
            }
        }
        if(catName.isEmpty() || catName == null){
            catName = "other";
        }
        return catName;
    }

}
