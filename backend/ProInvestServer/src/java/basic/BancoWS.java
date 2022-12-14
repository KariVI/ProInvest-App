
package basic;

import com.google.gson.Gson;
import dao.BancoDAO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Banco;


@Path("banco")
public class BancoWS {
    
    @Context
    private UriInfo context;
    
    public BancoWS() {
    }
    
    @GET
    @Path("getAllBancos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBancos(){
        ArrayList<Banco> lista = BancoDAO.getAllBancos();
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(lista)).build();
    }
    
    @GET
    @Path("getIdByNombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIdBancoByNombre(
            @PathParam("nombre") String nombre){
        Banco b = BancoDAO.getIdBancoByNombre(nombre);
        if(b!=null && b.getIdBanco()!=null){
            return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(b)).build();
        }
        return null;
    }
    
}
