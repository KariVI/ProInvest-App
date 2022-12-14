
package basic;

import dao.OrigenFondoDAO;
import java.util.ArrayList;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import pojos.OrigenFondo;

@Path("origenFondo")
public class OrigenFondoWS {

    
    public OrigenFondoWS() {
    }

    @GET
    @Path("allOrigenFondo")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<OrigenFondo> getAllOrigenFondo(){
        ArrayList<OrigenFondo> lista = OrigenFondoDAO.getAllOrigenFondo();
        return lista;
    }
    
    @GET
    @Path("getIdByOrigen/{origen}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrigenFondo getIdOrigenFondoByOrigen(
                @PathParam("origen") String origen){
        OrigenFondo origenFondo = OrigenFondoDAO.getIdOrigenFondoByOrigen(origen);
        if(origenFondo != null && origenFondo.getIdOrigenFondo() != null){
            return origenFondo;
        }
        
        return null;
    }
    
}
