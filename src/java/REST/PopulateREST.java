/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
    public String populateCategories(JSONObject jsonObject) {
        
        JSONObject o = (JSONObject) parser.parse(jsonObject);
        
        JSONArray categories = (JSONArray) o.get("Categories");
        
        for(Object i: categories){
                System.out.println(i+"");
            }
        
        return "Successfully consumed JSON and populated server";
    }
}

