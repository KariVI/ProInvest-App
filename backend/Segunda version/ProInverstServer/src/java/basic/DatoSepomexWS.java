/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import dao.DatoSepomexDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import pojos.DatoSepomex;

/**
 * REST Web Service
 *
 * @author david
 */
@Path("datoSepomex")
public class DatoSepomexWS {

    
    public DatoSepomexWS() {
    }

    @GET
    @Path("getByCp/{cp}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DatoSepomex> getByCp(
                @PathParam("cp") Integer cp
    ){
        List<DatoSepomex> lista = DatoSepomexDAO.getByCp(cp);    
        return lista;
    }
    
    @GET
    @Path("getIdByDatosSepomex")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer getIdByDatosSepomex(
            @FormParam("estado") String estado,
            @FormParam("municipio") String municipio,
            @FormParam("colonia") String colonia,
            @FormParam("cp") Integer cp
    ){
        DatoSepomex dato = new DatoSepomex(estado, municipio, colonia, cp);
        Integer idDatoSepomex = DatoSepomexDAO.getIdByDatosSepomex(dato);
        return idDatoSepomex;
    }
    
    @GET
    @Path("getById/{idDatoSepomex}")
    @Produces(MediaType.APPLICATION_JSON)
    public DatoSepomex getByIdDato(
           @PathParam("idDatoSepomex") Integer idDatoSepomex
    ){
        DatoSepomex dato = DatoSepomexDAO.getDatoById(idDatoSepomex);
        return dato;
    }
}
