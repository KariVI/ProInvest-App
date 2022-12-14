
package basic;

import dao.DatoSepomexDAO;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.DatoSepomex;

@Path("datoSepomex")
public class DatoSepomexWS {

    
    public DatoSepomexWS() {
    }
    
    @GET
    @Path("getByCp/{cp}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByCp(
                @PathParam("cp") Integer cp
    ){
        
        String holakari;
        List<DatoSepomex> lista = DatoSepomexDAO.getByCp(cp);    
        return Response.status(200).entity(lista).build();
    }
    
    @POST
    @Path("getIdByDatosSepomex")
    @Produces(MediaType.APPLICATION_JSON)
    public DatoSepomex getIdByDatosSepomex(
            @FormParam("estado") String estado,
            @FormParam("municipio") String municipio,
            @FormParam("colonia") String colonia,
            @FormParam("cp") Integer cp
    ){
        DatoSepomex dato = new DatoSepomex(estado, municipio, colonia, cp);
        dato.setIdDatoSepomex(DatoSepomexDAO.getIdByDatosSepomex(dato));
        return dato;
    }
    
    @GET
    @Path("getByIdDato/{idDatoSepomex}")
    @Produces(MediaType.APPLICATION_JSON)
    public DatoSepomex getByIdDato(
           @PathParam("idDatoSepomex") Integer idDatoSepomex
    ){
        DatoSepomex dato = DatoSepomexDAO.getDatoById(idDatoSepomex);
        return dato;
    }   
}
