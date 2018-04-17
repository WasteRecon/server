/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Model.GlobalModel;
import Model.Item;
import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



/**
 *
 * @author iosdev
 */
@Path("items")
public class ItemREST {
    public ItemREST() {
    }
    
    /**
     *
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addItem(JsonObject jsonObject) {
        String shape = jsonObject.getString("shape");
        String material = jsonObject.getString("material");
        return GlobalModel.getInstance().getCatNameFromItem(shape, material);
    }
}
