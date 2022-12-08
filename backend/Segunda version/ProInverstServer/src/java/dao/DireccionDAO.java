/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import pojos.Direccion;

/**
 *
 * @author carlosperezperez
 */
public class DireccionDAO {
    
    private static String driver = "com.mysql.jdbc.Driver";
    private static String database = "BlogNotas";
    private static String hostname = "localhost";
    private static String port = "3306";

    private static String URL = "jdbc:mysql://" + hostname + ":" + port + "/" + database
            + "?allowPublicKeyRetrieval=true&useSSL=false";

    private static String username = "root";
    private static String password = "lady16MAKEUP";

    public static Connection abrirConexionBD() {
        Connection c = null;
        try {
            Class.forName(driver);
            c = DriverManager.getConnection(URL, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
    
    public static ArrayList<Direccion> getAll(){
        ArrayList<Direccion> d = null;
        try{
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return d;
    }
}
