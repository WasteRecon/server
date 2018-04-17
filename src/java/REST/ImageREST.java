/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Model.GlobalModel;
import Model.Image;
import java.util.Base64;
import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author congthanhptnk
 */
@Path("images")
public class ImageREST {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Image> getAllImages(){
        return GlobalModel.getInstance().getAllImages();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postImage(JsonObject jsonObject){
        String base64Image = jsonObject.getString("img");
        String name = jsonObject.getString("name");
        String catName = jsonObject.getString("catName");
        
        byte[] img = Base64.getDecoder().decode(base64Image);
        Image newImage = new Image(name, img, catName);
        GlobalModel.getInstance().addImage(newImage);
        return "This image has been posted: " + name + " and" + catName;
    }
    
    @GET
    @Path("{catName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Image> getImagesOfCategory(@PathParam("catName") String catName){
        return GlobalModel.getInstance().getImagesOfCategory(catName);
    }
}
