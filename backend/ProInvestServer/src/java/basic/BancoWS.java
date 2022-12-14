
package basic;

import dao.BancoDAO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
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
    public ArrayList<Banco> getAllBancos(){
        ArrayList<Banco> lista = BancoDAO.getAllBancos();
        return lista;
    }
    
    @GET
    @Path("getIdByNombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Banco getIdBancoByNombre(
            @PathParam("nombre") String nombre){
        Banco b = BancoDAO.getIdBancoByNombre(nombre);
        if(b!=null && b.getIdBanco()!=null){
            return b;
        }
        return null;
    }
    
}
