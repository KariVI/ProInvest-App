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
import seguridad.AutorizacionTokenJWT;

/**
 * REST Web Service
 *
 * @author kari
 */
@Path("access")
public class AccessWS {
    
//    @POST
//    @Path("login")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Respuesta login(
//            @FormParam("email") String email,
//            @FormParam("contrasena") String contrasena
//    ) {
//        Respuesta res = new Respuesta();
//        //--------VALIDAR PARAMETROS DE ENTRADA--------------//
//        if(email==null || email.trim().isEmpty()){
//            res.setError(true);
//            res.setMensaje("El email es un dato requerido...");
//            return res;
//        }else if(contrasena==null || contrasena.trim().isEmpty()){
//            res.setError(true);
//            res.setMensaje("La contraseña es un dato requerido...");
//            return res;
//        }
//        //--------VALIDAR CREDENCIALES DEL EMPLEADO----------//
//        User u = UserDAO.login(email, contrasena);
//        if(u==null) {
//            res.setError(true);
//            res.setMensaje("No se encontró ningún empleado con esas credenciales...");
//            return res;
//        }
//        //------GENERAR TOKEN CON JWT Y DEVOLVERLO-----------//
//        SesionToken s = new SesionToken(); s.setId(u.getIdUser());
//        s.setEmail(u.getCorreo());
//        s = AutorizacionTokenJWT.generarToken(s);
//        if(s==null || s.getTokenacceso()==null || s.getTokenacceso().isEmpty()){
//            res.setError(true);
//            res.setMensaje("No se puede generar el token de acceso...");
//        }else{
//            res.setError(false);
//            res.setMensaje("Bienvenido: "+s.getEmail());
//            res.setSesiontoken(s);
//        }
//        //---------------------------------------------------//
//        return res;
//    }
    
    
    
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
    
    @POST
    @Path("valiartoken")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta validarToken(
            @FormParam("token") String token
    ){
        Respuesta res = new Respuesta();
        //--------VALIDAR PARAMETROS DE ENTRADA--------------//
        if(token==null || token.trim().isEmpty()){
            res.setError(true);
            res.setMensaje("El token es un dato requerido...");
            return res;
        }
        //--------------VALIDAR TOKEN DE JWT-----------------//
        res = AutorizacionTokenJWT.validarToken(token);
        //---------------------------------------------------//
        return res;
    }
    
}
