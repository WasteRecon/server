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

/**
 *
 * @author congthanhptnk
 */
public class GlobalModel {
    
    private final List<Category> categories = new ArrayList();
    private final List<Item> items = new ArrayList();
    
    private GlobalModel() {
        items.add(new Item("plasticBottle", "bottle", "plastic"));
        items.add(new Item("glassBottle", "bottle", "glass"));
        items.add(new Item("paperBottle", "bottle", "paper"));
        items.add(new Item("clothes", "shirt", "fabric"));
        items.add(new Item("clothes", "pants", "fabric"));
        items.add(new Item("plasticClothes", "shirt", "plastic"));
        items.add(new Item("plasticClothes", "pants", "plastic"));
        items.add(new Item("lightBulb", "lightbulb", "glass"));
        items.add(new Item("plasticCup", "cup", "plastic"));
        items.add(new Item("glassCup", "cup", "glass"));
        items.add(new Item("paperCup", "cup", "paper")); 
    }
    
    public static GlobalModel getInstance() {
        return GlobalModelHolder.INSTANCE;
    }
    
    private static class GlobalModelHolder {

        private static final GlobalModel INSTANCE = new GlobalModel();
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
    
    public void addCategory(Category c) {
        this.categories.add(c);
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
