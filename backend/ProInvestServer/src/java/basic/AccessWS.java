
package basic;

import com.google.gson.Gson;
import dao.UserDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        
        User u = new User();
        
        boolean res = UserDAO.registrarUser(u);
        if (res) {
            resultado = new Mensaje("Usuario registrado con éxito", false);
        } else {
            resultado = new Mensaje("Error, no se pudo registrar el usuario", true);
        }
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(resultado)).build();
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
            resultado = new Mensaje("Usuario encontrado, you ate", false);
        } else {
            resultado = new Mensaje("Error, you thought you ate but u didn't", true);
        }
        return resultado;
    }    
}
