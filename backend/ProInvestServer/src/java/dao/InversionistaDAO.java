/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.UserDAO.abrirConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import pojos.Inversionista;
import pojos.User;

/**
 *
 * @author carlosperezperez
 */
public class InversionistaDAO {
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
    
    public static boolean crearInversionista(Inversionista i) {
        boolean regInv = false;
        Connection con = abrirConexionBD();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        if (con != null) {
            try {
                String consulta = "INSERT INTO inversionista (apellidoPaterno, apellidoMaterno, celular, direccionip, fechaNacimiento, nombre, rfc, profesion, idGradoAcademico, idUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(consulta);
                ps.setString(1, i.getApellidoPaterno());
                ps.setString(1, i.getApellidoMaterno());
                ps.setString(1, i.getCelular());
                ps.setString(1, i.getDireccionip());
                ps.setDate(1, (java.sql.Date) i.getFechaNacimiento());
                ps.setString(1, i.getNombre());
                ps.setString(1, i.getRfc());
                ps.setString(1, i.getProfesion());
                ps.setInt(1, i.getIdGradoAcademico());
                ps.setInt(1, i.getIdInversionista());
                
                int respIns = ps.executeUpdate();
                regInv = (respIns > 0);
            } catch (SQLException s) {
                System.out.println(s.getMessage());
                s.printStackTrace();
            }
        }
        return regInv;
    }
    
    public static Inversionista getIdBy(String rfc) {
        boolean existe = false;
        Connection con = abrirConexionBD();
        Inversionista i = new Inversionista();
        if (con != null) {
            try {
                String consulta = "SELECT * from inversionista WHERE rfc = ?";
                PreparedStatement ps = con.prepareStatement(consulta);
                ps.setString(1, rfc);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    i.setIdInversionista(rs.getInt("idInversionista"));
                    i.setNombre(rs.getString("nombre"));
                    i.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    i.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    i.setCelular(rs.getString("celular"));
                    i.setDireccionip(rs.getString("direccionIp"));
                    i.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    i.setProfesion(rs.getString("profesion"));
                }
                con.close();
            } catch (SQLException s) {
                System.out.println(s.getMessage());
                s.printStackTrace();
            }
        }
        return i;
    }
}
