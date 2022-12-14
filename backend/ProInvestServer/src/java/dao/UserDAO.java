
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import pojos.User;


public class UserDAO {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String database = "ProInvest";
    private static String hostname = "localhost";
    private static String port = "3306";

    private static String URL = "jdbc:mysql://" + hostname + ":" + port + "/" + database
            + "?allowPublicKeyRetrieval=true&useSSL=false";

    private static String username = "root";
    private static String password = "lady16MAKEUP"; //Fairy59Atomic12

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
    
    public static boolean getByCorreo(String correo) {
        boolean existe = false;
        Connection con = abrirConexionBD();
        User u = new User();
        if (con != null) {
            try {
                String consulta = "SELECT * from usuario WHERE correo = ?";
                PreparedStatement ps = con.prepareStatement(consulta);
                ps.setString(1, correo);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    u.setIdUser(rs.getInt("idUsuario"));
                    u.setCorreo(rs.getString("correo"));
                }
                con.close();
                if (u.getIdUser() != null) {
                    existe = true;
                }
            } catch (SQLException s) {
                System.out.println(s.getMessage());
                s.printStackTrace();
            }
        }
        return existe;
    }
    
    public static User getUserByEmail (String correo){
        Connection con = abrirConexionBD();
        User u = new User();
        if (con != null) {
            try {
                String consulta = "SELECT * from usuario WHERE correo = ?";
                PreparedStatement ps = con.prepareStatement(consulta);
                ps.setString(1, correo);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    u.setIdUser(rs.getInt("idUsuario"));
                    u.setCorreo(rs.getString("correo"));
                    u.setContrasena(rs.getString("contrasena"));
                }
                con.close();
                
            } catch (SQLException s) {
                System.out.println(s.getMessage());
                s.printStackTrace();
            }
        }
        return u;
    }
    
    
}
