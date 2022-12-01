/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.github.javafaker.Faker;
import java.util.Locale;
import pojos.User;
import java.util.Date;

/**
 *
 * @author kari
 */
public class UserDAO {
    
    public static User login(String email, String contrasena) {
        Date date = new Date();
        User u = null;
        //--------------------------//
        try {
            if(contrasena.compareToIgnoreCase("SoloEstaContrasenaEsCorrecta12345")==0){
                Faker df = new Faker(new Locale("es-MX"));
                u = new User(
                        email, df.internet().password(8, 16, true, true, true), date
                );
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //--------------------------//
        return u;
    }
}
