
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojos.Banco;


public class BancoDAO {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String database = "ProInvest";
    private static String hostname = "localhost";
    private static String port = "3306";

    private static String URL = "jdbc:mysql://" + hostname + ":" + port + "/" + database
            + "?allowPublicKeyRetrieval=true&useSSL=false";

    private static String username = "root";
    private static String password = "Fairy59Atomic12"; //lady16MAKEUP

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
    
    public static ArrayList<Banco> getAllBancos(){
        ArrayList<Banco> lista = new ArrayList<>();
        Connection connection = abrirConexionBD();
        if (connection != null){
            try{
                String consulta = "SELECT * FROM banco";
                PreparedStatement ps = connection.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Integer idBanco = rs.getInt("idBanco");
                    String nombre = rs.getString("nombre");
                    Banco banco = new Banco(idBanco, nombre);
                    lista.add(banco);
                }
                connection.close();
            }catch(SQLException s){
                System.out.println(s.getMessage());
                s.printStackTrace(); 
            }
        }
        return lista;
    }
    
    public static Banco getIdBancoByNombre(String nombre){
        Banco b = new Banco();
        Connection connection = abrirConexionBD();
        if (connection != null){
            try{
                String consulta = "SELECT * FROM banco WHERE nombre = ?";
                PreparedStatement ps = connection.prepareStatement(consulta);
                ps.setString(1, nombre);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    b.setIdBanco(rs.getInt("idBanco"));
                }
                connection.close();
            }catch(SQLException s){
                System.out.println(s.getMessage());
                s.printStackTrace(); 
            }
        }
        return b;
    }
}
