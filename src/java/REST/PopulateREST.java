/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author roba
 */
@Path("populate")
public class PopulateREST {
    public PopulateREST() {
    }
    
    
    private final JSONParser parser = new JSONParser();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String populateCategories(JsonObject jsonObject) {
        JsonArray arr = jsonObject.getJsonArray("Categories");
        
        for(JsonValue x: arr){
            String name = x.asJsonObject().getString("name");
            System.out.print(name);
        }
        //for(Object i: categories){
          //      System.out.println(i+"");
            //}    
        //System.out.print(arr);
        return "Successfully consumed JSON and populated server";
    }
    
    @POST
    @Path("test")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String populate(String j) {
        //String categories = j.get("Categories").toString();
        try{
        JSONObject o = (JSONObject)this.parser.parse(j);
        JSONArray categories = (JSONArray)o.get("Categories");
        for(Object x: categories){
            System.out.print(x);
        }
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.print("abc: Parse exception");
        }
        //for(Object i: categories){
          //      System.out.println(i+"");
            //}    
        //System.out.print(categories);
        return "Successfully consumed JSON and populated server";
    }
}

