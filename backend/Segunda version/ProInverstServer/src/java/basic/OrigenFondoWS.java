/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import dao.OrigenFondoDAO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import pojos.OrigenFondo;

/**
 * REST Web Service
 *
 * @author david
 */
@Path("origenFondo")
public class OrigenFondoWS {
    
    public OrigenFondoWS(){
        
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<OrigenFondo> getAllOrigenFondo(){
        ArrayList<OrigenFondo> lista = OrigenFondoDAO.getAllOrigenFondo();
        return lista;
    }
    
    @GET
    @Path("getIdByOrigen")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer getIdOrigenFondoByOrigen(
                @FormParam("origen") String origen){
        Integer idOrigenFondo = OrigenFondoDAO.getIdOrigenFondoByOrigen(origen);
        return idOrigenFondo;
    }
   
    
}
