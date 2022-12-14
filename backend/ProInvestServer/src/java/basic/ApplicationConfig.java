/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author david
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(basic.AccessWS.class);
        resources.add(basic.BancoWS.class);
        resources.add(basic.DatoSepomexWS.class);
        resources.add(basic.DireccionWS.class);
        resources.add(basic.InformacionFinancieraWS.class);
        resources.add(basic.OrigenFondoWS.class);

    }   
    
}
