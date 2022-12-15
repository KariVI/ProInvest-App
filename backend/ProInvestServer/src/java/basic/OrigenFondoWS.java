
package basic;

import com.google.gson.Gson;
import dao.OrigenFondoDAO;
import java.util.ArrayList;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.OrigenFondo;

@Path("origenFondo")
public class OrigenFondoWS {

    
    public OrigenFondoWS() {
    }

    @GET
    @Path("allOrigenFondo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrigenFondo(){
        ArrayList<OrigenFondo> lista = OrigenFondoDAO.getAllOrigenFondo();
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(lista)).build();
    }
    
    @GET
    @Path("getIdByOrigen/{origen}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIdOrigenFondoByOrigen(
                @PathParam("origen") String origen){
        OrigenFondo origenFondo = OrigenFondoDAO.getIdOrigenFondoByOrigen(origen);
        if(origenFondo != null && origenFondo.getIdOrigenFondo() != null){
            return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(origenFondo)).build();
        }
        
        return null;
    }
    
}
