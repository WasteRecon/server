/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Model.Category;
import Model.GlobalModel;
import java.util.Base64;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    public String populateCategories(JsonObject jsonObject) {
        JsonArray arr = jsonObject.getJsonArray("Categories");
        
        for(JsonValue x: arr){
            String catName = x.asJsonObject().getString("catName");
            String title = x.asJsonObject().getString("title");
            String desc = x.asJsonObject().getString("description");
            String facts = x.asJsonObject().getString("facts");
            String img64 = x.asJsonObject().getString("img");
            
            byte[] imgByte = Base64.getDecoder().decode(img64);
            
            GlobalModel.getInstance().addCategory(new Category(catName, title, desc, facts, imgByte));
        }
        return "Successfully consumed JSON and populated server";
    }
}

