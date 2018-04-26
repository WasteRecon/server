/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import java.io.FileNotFoundException;
import java.io.IOException;
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
        System.out.print(arr);
        return "Successfully consumed JSON and populated server";
    }
}

