/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import dao.InformacionFinancieraDAO;
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
import pojos.InformacionFinanciera;
import pojos.Mensaje;

/**
 * REST Web Service
 *
 * @author david
 */
@Path("informacionFinanciera")
public class InformacionFinancieraWS {

    
    public InformacionFinancieraWS() {
    }

    @POST
    @Path("registrar")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registrarInformacionFinanciera(   
            @FormParam("idBanco") Integer idBanco,
            @FormParam("clabe") String clabe,
            @FormParam("cuenta") String cuenta,
            @FormParam("idOrigenFondo") Integer idOrigenFondo
    ){
        Mensaje mensaje;
        InformacionFinanciera informacion = new InformacionFinanciera(idBanco, clabe, cuenta, idOrigenFondo);
        boolean resultado = InformacionFinancieraDAO.saveInformacionFinanciera(informacion);
        if(resultado){
            mensaje = new Mensaje("Registro con éxito", false);
        }else{
            mensaje = new Mensaje("No se pudo registrar", true);
        }
        return mensaje;
    }
    
    @POST
    @Path("validarDatos")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje existeInformacionFinanciera(
            @FormParam("clabe") String clabe,
            @FormParam("cuenta") String cuenta
    ){
        Mensaje mensaje;
        boolean resultado = InformacionFinancieraDAO.existsInformacionFinanciera(clabe, cuenta);
        if(resultado){
            mensaje = new Mensaje("Datos existentes", false);
        }else{
            mensaje = new Mensaje("Los datos no existen", true);
        }
        return mensaje;
    }
}
