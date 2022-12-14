
package basic;

import com.google.gson.Gson;
import dao.DatoSepomexDAO;
import dao.UserDAO;
import java.util.List;
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
import pojos.DatoSepomex;
import pojos.Mensaje;
import pojos.User;

@Path("access")
public class AccessWS {
    
    public AccessWS() {
    }
    
    @POST
    @Path("signup")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(
            @FormParam("correo") String correo,
            @FormParam("contrasena") String contrasena
    ) {
        Mensaje resultado;
       
        User u = new User(correo,contrasena);
        boolean res = UserDAO.registrarUser(u);
        if (res) {
            resultado = new Mensaje("Usuario registrado con éxito", false);
        } else {
            resultado = new Mensaje("Error, no se pudo registrar el usuario", true);
        }
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(resultado)).build();
    }
    
    @GET
    @Path("getByCorreo/{correo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByCorreo(
                @PathParam("correo") String correo
    ){
        
        boolean u = UserDAO.getByCorreo(correo);
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(u)).build();
    } 
    
    @GET
    @Path("getUserByEmail/{correo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByEmail(
                @PathParam("correo") String correo
    ){
        
        User u = UserDAO.getUserByEmail(correo);
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(u)).build();
    } 
    
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje loginUsuario(
            @FormParam("correo") String correo,
            @FormParam("contrasena") String contrasena
    ){
        Mensaje resultado;
        
        User u = new User();
        
        boolean res = UserDAO.loginUser(correo, contrasena);
        if (res) {
            resultado = new Mensaje("Usuario encontrado", false);
        } else {
            resultado = new Mensaje("Error, usuario no encontrado", true);
        }
        return resultado;
    }    
}
