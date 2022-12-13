/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

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
import pojos.Direccion;
import pojos.Mensaje;

/**
 * REST Web Service
 *
 * @author david
 */
@Path("direccion")
public class DireccionWS {

   
    public DireccionWS() {
    }
    
    @GET
    @Path("getByIdDireccion/{idDireccion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Direccion getByIdDireccion(
            @PathParam("idDireccion") Integer idDireccion
    ){
        Direccion direccion = DireccionDAO.getByIdDireccion(idDireccion);
        return direccion;
    }
    
    @GET
    @Path("getByIdInversionista/{idInversionista}")
    @Produces(MediaType.APPLICATION_JSON)
    public Direccion getByIdInversionista(
            @PathParam("idInversionista") Integer idInversionista
    ){
        Direccion direccion = DireccionDAO.getByIdInversionista(idInversionista);
        return direccion;
    }
    
    @POST
    @Path("registrarDireccion")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registrarDireccion(
            @FormParam("calle") String calle,
            @FormParam("numeroExterior") Integer numeroExterior,
            @FormParam("numeroInterior") Integer numeroInterior,
            @FormParam("idDatoSepomex") Integer idDatoSepomex,
            @FormParam("idInversionista") Integer idInversionista
    ){
        Mensaje mensaje;
        Direccion direccion = new Direccion(calle, numeroExterior, numeroInterior, idDatoSepomex, idInversionista);
        boolean resultado = DireccionDAO.saveDireccion(direccion);
        if(resultado){
            mensaje = new Mensaje("Registro con éxito", false);
        }else{
            mensaje = new Mensaje("No se pudo registrar", true);
        }
        return mensaje;
    }
    
}
