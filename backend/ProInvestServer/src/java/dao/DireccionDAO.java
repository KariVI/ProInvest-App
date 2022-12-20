
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojos.Direccion;


public class DireccionDAO {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String database = "ProInvest";
    private static String hostname = "localhost";
    private static String port = "3306";

    private static String URL = "jdbc:mysql://" + hostname + ":" + port + "/" + database
            + "?allowPublicKeyRetrieval=true&useSSL=false";

    private static String username = "root";
    private static String password = "";

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
    
    public static Direccion getByIdDireccion(int idDireccion){
        Direccion direccion = new Direccion();
        Connection connection = abrirConexionBD();
        if(connection != null){
            try{
                String consulta = "SELECT * FROM direccion WHERE idDireccion = ?";
                PreparedStatement ps = connection.prepareStatement(consulta);
                ps.setInt(1, idDireccion);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    direccion.setIdDireccion(idDireccion);
                    direccion.setCalle(rs.getString("calle"));
                    direccion.setNumeroExterior(rs.getInt("numeroExterior"));
                    direccion.setNumeroInterior(rs.getInt("numeroInterior"));
                    direccion.setIdDatoSepomex(rs.getInt("idDatosSepomex"));
                    direccion.setIdInversionista(rs.getString("idInversionista"));
                }
                connection.close();
            }catch(SQLException s){
                System.out.println(s.getMessage());
                s.printStackTrace();
            }
        }
        return direccion;
    }
    
    public static Direccion getByIdInversionista(String idInversionista){
        Direccion direccion = new Direccion();
        Connection connection = abrirConexionBD();
        if(connection != null){
            try{
                String consulta = "SELECT * FROM direccion WHERE idInversionista = ?";
                PreparedStatement ps = connection.prepareStatement(consulta);
                ps.setString(1, idInversionista);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    direccion.setIdInversionista(idInversionista);
                    direccion.setCalle(rs.getString("calle"));
                    direccion.setNumeroExterior(rs.getInt("numeroExterior"));
                    direccion.setNumeroInterior(rs.getInt("numeroInterior"));
                    direccion.setIdDatoSepomex(rs.getInt("idDatosSepomex"));
                    direccion.setIdDireccion(rs.getInt("idDireccion"));
                }
                connection.close();
            }catch(SQLException s){
                System.out.println(s.getMessage());
                s.printStackTrace();
            }
        }
        return direccion;
    }
    
    public static boolean saveDireccion(Direccion direccion){
        boolean saved = false;
        Connection connection = abrirConexionBD();
        if(connection != null){
            try{
                String consulta = "INSERT INTO direccion (calle, numeroExterior, numeroInterior, idDatosSepomex, idInversionista)"
                                + "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(consulta);
                ps.setString(1, direccion.getCalle());
                ps.setInt(2, direccion.getNumeroExterior());
                ps.setInt(3, direccion.getNumeroInterior());
                ps.setInt(4, direccion.getIdDatoSepomex());
                ps.setString(5, direccion.getIdInversionista());
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
}
