
package basic;

import com.google.gson.Gson;
import dao.DireccionDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Direccion;
import pojos.Mensaje;


@Path("direccion")
public class DireccionWS {

    public DireccionWS() {
    }
    
    @GET
    @Path("getByIdDireccion/{idDireccion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIdDireccion(
            @PathParam("idDireccion") Integer idDireccion
    ){
        Direccion direccion = DireccionDAO.getByIdDireccion(idDireccion);
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(direccion)).build();
    }
    
    @GET
    @Path("getByIdInversionista/{idInversionista}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIdInversionista(
            @PathParam("idInversionista") String idInversionista
    ){
        Direccion direccion = DireccionDAO.getByIdInversionista(idInversionista);
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(direccion)).build();
    }
    
    @POST
    @Path("registrarDireccion")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarDireccion(
            @FormParam("calle") String calle,
            @FormParam("numeroExterior") Integer numeroExterior,
            @FormParam("numeroInterior") Integer numeroInterior,
            @FormParam("idDatoSepomex") Integer idDatoSepomex,
            @FormParam("idInversionista") String idInversionista
    ){
        Mensaje mensaje;
        Direccion direccion = new Direccion(calle, numeroExterior, numeroInterior, idDatoSepomex, idInversionista);
        boolean resultado = DireccionDAO.saveDireccion(direccion);
        if(resultado){
            mensaje = new Mensaje("Registro con éxito", false);
        }else{
            mensaje = new Mensaje("No se pudo registrar", true);
        }
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(mensaje)).build();
    }   
}
