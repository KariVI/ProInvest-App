
package pojos;

import java.util.Date;


public class User {
    private Integer idUser;
    private String contrasena;
    private String correo;
    private Date horaAcceso;
    
    public User () {
        
    }
    
    public User (String contrasena, String correo, Date horaAcceso) {
        this.contrasena = contrasena;
        this.correo = correo;
        this.horaAcceso = horaAcceso;
    }

    public User(String correo, String contrasena) {
        this.contrasena = contrasena;
        this.correo = correo;
    }
    
    public Integer getIdUser() {
        return idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getHoraAcceso() {
        return horaAcceso;
    }

    public void setHoraAcceso(Date horaAcceso) {
        this.horaAcceso = horaAcceso;
    }
}
