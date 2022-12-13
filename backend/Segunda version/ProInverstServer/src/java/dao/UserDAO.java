/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import pojos.User;
import java.util.Date;

/**
 *
 * @author kari
 */
public class UserDAO {
    
    private static String driver = "com.mysql.jdbc.Driver";
    private static String database = "ProInvest";
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
    
    public static boolean loginUser(String correo, String contrasena) {
        boolean login = false;
        Connection con = abrirConexionBD();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        User u = new User();
        if (con != null) {
            try {
                String consulta = "SELECT * from usuario WHERE correo = ? AND contrasena = ?";
                PreparedStatement ps = con.prepareStatement(consulta);
                ps.setString(1, correo);
                ps.setString(2, contrasena);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    u.setIdUser(rs.getInt("idUsuario"));
                    u.setCorreo(rs.getString("correo"));
                    u.setHoraAcceso(date);
                }
                con.close();
                if (u.getIdUser() != null) {
                    login = true;
                }
            } catch (SQLException s) {
                System.out.println(s.getMessage());
                s.printStackTrace();
            }
        }
        return login;
    }

    public static boolean registrarUser(User u) {
        boolean registro = false;
        Connection con = abrirConexionBD();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        if (con != null) {
            try {
                String consulta = "INSERT INTO usuario (correo, contrasena) VALUES (?, ?)";
                PreparedStatement ps = con.prepareStatement(consulta);
                ps.setString(1, u.getCorreo());
                ps.setString(2, u.getContrasena());
                int respIns = ps.executeUpdate();
                registro = (respIns > 0);
            } catch (SQLException s) {
                System.out.println(s.getMessage());
                s.printStackTrace();
            }
        }
        return registro;
    }
    
    
}
