/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.Date;

/**
 *
 * @author kari
 */
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
