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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author roba
 */
public class CategoriesData {
    
    private List<Category> categories = new ArrayList();
    private JSONObject c;
    
    private JSONParser parser = new JSONParser();
    
    private File f;

    
    //MARK: Initializing the categories
    
    public CategoriesData() {
        this.f = new File(".");
    }
    
    public void readJson() {
        try {
            
            Object obj = parser.parse(new FileReader("categories.json"));

            JSONObject jsonObject = (JSONObject) obj;
            
            this.c = (JSONObject) jsonObject.get("categories");
            
            System.out.print(this.c);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public List<Category> populateCategories() {
        //readJson();
        //System.out.print("kakka: " + new File(".").getAbsolutePath());
        
        return categories;
    }
}
