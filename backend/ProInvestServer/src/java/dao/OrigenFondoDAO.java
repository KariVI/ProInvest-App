
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojos.OrigenFondo;


public class OrigenFondoDAO {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String database = "ProInvest";
    private static String hostname = "localhost";
    private static String port = "3306";

    private static String URL = "jdbc:mysql://" + hostname + ":" + port + "/" + database
            + "?allowPublicKeyRetrieval=true&useSSL=false";

    private static String username = "root";
    private static String password = "Fairy59Atomic12";

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
    
    public static ArrayList<OrigenFondo> getAllOrigenFondo(){
        ArrayList<OrigenFondo> lista = new ArrayList<>();
        Connection connection = abrirConexionBD();
        if (connection != null){
            try{
                String consulta = "SELECT * FROM origenFondo";
                PreparedStatement ps = connection.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Integer idOrigenFondo = rs.getInt("idOrigenFondo");
                    String origen = rs.getString("origen");
                    OrigenFondo origenFondo = new OrigenFondo(idOrigenFondo, origen);
                    lista.add(origenFondo);
                }
                connection.close();
            }catch(SQLException s){
                System.out.println(s.getMessage());
                s.printStackTrace(); 
            }
        }
        return lista;
    }
    
    public static OrigenFondo getIdOrigenFondoByOrigen(String origen){
        OrigenFondo origenFondo = new OrigenFondo();
        Connection connection = abrirConexionBD();
        if (connection != null){
            try{
                String consulta = "SELECT * FROM origenFondo WHERE origen = ?";
                PreparedStatement ps = connection.prepareStatement(consulta);
                ps.setString(1, origen);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    origenFondo.setIdOrigenFondo(rs.getInt("idOrigenFondo"));
                }
                connection.close();
            }catch(SQLException s){
                System.out.println(s.getMessage());
                s.printStackTrace(); 
            }
        }
        return origenFondo;
    }
}
