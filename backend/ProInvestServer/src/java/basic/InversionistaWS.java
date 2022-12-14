/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package basic;

import com.google.gson.Gson;
import dao.InversionistaDAO;
import dao.UserDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import pojos.Inversionista;
import pojos.Mensaje;
import pojos.User;

/**
 * REST Web Service
 *
 * @author carlosperezperez
 */
@Path("inversionistaws")
public class InversionistaWS {
    
    public InversionistaWS(){
        
    }
    
    @POST
    @Path("crearInversionista")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("celular") String celular,
            @FormParam("direccionip") String direccionip,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("nombre") String nombre,
            @FormParam("rfc") String rfc,
            @FormParam("profesion") String profesion,
            @FormParam("idGradoAcademico") Integer idGradoAcademico,
            @FormParam("idUsuario") Integer idUsuario
    ) throws ParseException {
        System.out.println("Entrando a crear inversionista");
        Mensaje resultado;
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
        Date fechaNacimientoNueva = formato.parse(fechaNacimiento);
       
        Inversionista i = new Inversionista(apellidoPaterno, apellidoMaterno, celular, direccionip, fechaNacimientoNueva, nombre, rfc, profesion, idGradoAcademico, idUsuario);
        boolean res = InversionistaDAO.crearInversionista(i);
        if (res) {
            resultado = new Mensaje("Usuario registrado con ??xito", false);
        } else {
            resultado = new Mensaje("Error, no se pudo registrar el usuario", true);
        }
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(resultado)).build();
    }
    
    @GET
    @Path("getByRfc/{rfc}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByCorreo(
                @PathParam("rfc") String rfc
    ){
        
        String holakari;
        int i = InversionistaDAO.getIdBy(rfc);
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(i)).build();
    }  
    
}
