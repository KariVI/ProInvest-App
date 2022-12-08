/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package basic;

import dao.DireccionDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import pojos.Direccion;

/**
 * REST Web Service
 *
 * @author carlosperezperez
 */
@Path("inversionista")
public class InversionistaWS {

    @GET
    @Path("listardirecciones")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Direccion> getAllDirecciones(@PathParam("idUsuario") Integer idUsuario){
        List<Direccion> list = DireccionDAO.getAll();
        return list;
    }
    
}
