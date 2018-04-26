/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author roba
 */
public class CategoriesData {
    
    private List<Item> items = new ArrayList();
    
    private JSONParser parser = new JSONParser();

    
    //MARK: Initializing the categories
    
    public CategoriesData() {
    }
    
    public void readJson() {
        //File x = new File("/WasteRecon/newjson.json");
        //System.out.println(x.getAbsolutePath());
        try {            
            JSONObject o = (JSONObject) parser.parse(new FileReader("/Users/roba/Documents/WasteRecon-project/server/newjson.json"));
            JSONArray items = (JSONArray) o.get("items");
            
            for(Object i: items){
                System.out.println(i+"");
            }
            
            /*for (Object o: jsonArray){
                JSONObject item = (JSONObject) o;
                
                JSONArray items = (JSONArray) item.get("items");
                
                for(Object i: items){
                    System.out.println(i+"");
                }
            }*/
            
            System.out.print("xyz");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print("abc: File not found exception");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("abc: IOException");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.print("abc: Parse exception");
        }
    }
    
    public List<Item> populateCategories() {
        readJson();
        System.out.println("qwerty: this works");
        
        return items;
    }
}
