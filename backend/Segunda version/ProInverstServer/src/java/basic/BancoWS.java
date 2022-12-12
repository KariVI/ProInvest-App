/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import dao.BancoDAO;
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
import pojos.Banco;

/**
 * REST Web Service
 *
 * @author david
 */
@Path("banco")
public class BancoWS {

    
    public BancoWS() {
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Banco> getAllBancos(){
        ArrayList<Banco> lista = BancoDAO.getAllBancos();
        return lista;
    }
    
    @GET
    @Path("getIdByNombre")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer getIdBancoByNombre(
            @FormParam("nombre") String nombre){
        Integer idBanco = BancoDAO.getIdBancoByNombre(nombre);
        return idBanco;
    }
}
