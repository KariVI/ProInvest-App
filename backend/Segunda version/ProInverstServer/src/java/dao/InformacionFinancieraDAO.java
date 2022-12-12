/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DireccionDAO.abrirConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.InformacionFinanciera;

/**
 *
 * @author david
 */
public class InformacionFinancieraDAO {
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
    
    public static boolean saveInformacionFinanciera(InformacionFinanciera informacion){
        boolean saved = false;
        Connection connection = abrirConexionBD();
        if(connection != null){
            try{
               String consulta = "INSERT INTO informacionFinanciera (idBanco, clabe, cuenta, idOrigenFondo) VALUES "
                                + "(?, ?, ?, ?)";
               PreparedStatement ps = connection.prepareStatement(consulta);
               ps.setInt(1, informacion.getIdBanco());
               ps.setString(2, informacion.getClabe());
               ps.setString(3, informacion.getCuenta());
               ps.setInt(4, informacion.getIdOrigenFondo());
               ps.executeUpdate();
               saved = true;
               connection.close();
            }catch(SQLException s){
                System.out.println(s.getMessage());
                s.printStackTrace();
            }
        }
        return saved;
    }
    
    public static boolean existsInformacionFinanciera(String clabe, String cuenta){
        boolean exists = false;
        Connection connection = abrirConexionBD();
        if(connection != null){
            try{
                String consulta = "SELECT * FROM informacionFinanciera WHERE clabe = ? AND cuenta = ?";
                PreparedStatement ps = connection.prepareStatement(consulta);
                ps.setString(1, clabe);
                ps.setString(2, cuenta);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    exists = true;
                }    
                connection.close();
            }catch(SQLException s){
                System.out.println(s.getMessage());
                s.printStackTrace();
            }
        }
        return exists;
    }
}
