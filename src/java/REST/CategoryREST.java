/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Model.GlobalModel;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author roba
 */
@Path("/categories")
public class CategoryREST {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCategories() {
        return GlobalModel.getInstance().getAllCategories();
    }
    
    @GET
    @Path("{catName}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSingleCategory(@PathParam("catName") String catName) {
        return GlobalModel.getInstance().getSingleCategory(catName);
    }
}
