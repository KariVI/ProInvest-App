
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.DatoSepomex;


public class DatoSepomexDAO {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String database = "ProInvest";
    private static String hostname = "localhost";
    private static String port = "3306";

    private static String URL = "jdbc:mysql://" + hostname + ":" + port + "/" + database
            + "?allowPublicKeyRetrieval=true&useSSL=false";

    private static String username = "root";
    private static String password = "amoapumas";

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
    
    public static List<DatoSepomex> getByCp(Integer cp){
        List<DatoSepomex> lista = new ArrayList<>();
        Connection connection = abrirConexionBD();
        if (connection != null){
            try{
                String consulta = "SELECT * FROM datosSepomex WHERE cp = ?";
                PreparedStatement ps = connection.prepareStatement(consulta);
                ps.setInt(1, cp);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idDatoSepomex = rs.getInt("idDatosSepomex");
                    String estado = rs.getString("estado");
                    String municipio = rs.getString("municipio");
                    String colonia = rs.getString("asentamiento");
                    DatoSepomex dato = new DatoSepomex(idDatoSepomex, estado, municipio, colonia, cp);
                    lista.add(dato);
                }
                connection.close();
            }catch(SQLException s){
                System.out.println(s.getMessage());
                s.printStackTrace(); 
            }
        }
        return lista;
    }
    
    public static Integer getIdByDatosSepomex(DatoSepomex dato){
        Integer idDatoSepomex = null;
        Connection connection = abrirConexionBD();
        if (connection != null){
            try{
                String consulta = "SELECT * FROM datosSepomex WHERE estado = ? AND municipio = ? AND asentamiento = ? AND cp = ?";
                PreparedStatement ps = connection.prepareStatement(consulta);
                ps.setString(1, dato.getEstado());
                ps.setString(2, dato.getMunicipio());
                ps.setString(3, dato.getColonia());
                ps.setInt(4, dato.getCp());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    idDatoSepomex = rs.getInt("idDatosSepomex");
                }
                connection.close();
            }catch(SQLException s){
                System.out.println(s.getMessage());
                s.printStackTrace(); 
            }
        }
        return idDatoSepomex;
    }
    
    public static DatoSepomex getDatoById(int idDatoSepomex){
        DatoSepomex dato = new DatoSepomex();
        Connection connection = abrirConexionBD();
        if(connection != null){
            try{
                String consulta = "SELECT * FROM datosSepomex WHERE idDatosSepomex = ?";
                PreparedStatement ps = connection.prepareStatement(consulta);
                ps.setInt(1, idDatoSepomex);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    dato.setIdDatoSepomex(idDatoSepomex); 
                    dato.setEstado(rs.getString("estado"));
                    dato.setMunicipio(rs.getString("municipio"));
                    dato.setColonia(rs.getString("asentamiento"));
                    dato.setCp(rs.getInt("cp"));
                }
                connection.close();
            }catch(SQLException s){
                System.out.println(s.getMessage());
                s.printStackTrace();
            }
        }
        return dato;
    }
}
