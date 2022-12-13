/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import dao.UserDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import pojos.Mensaje;
import pojos.Respuesta;
import pojos.SesionToken;
import pojos.User;

/**
 * REST Web Service
 *
 * @author kari
 */
@Path("access")
public class AccessWS {
    
    @POST
    @Path("signup")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registrarUsuario(
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
        return resultado;
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
