package pojos;

import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author carlosperezperez
 */
public class Respuesta {
    private boolean error;
    private String mensaje;
    private User empleado;
    private List<User> lista;
    private SesionToken sesiontoken;
    
    public Respuesta() {
        
    }
    
    public Respuesta(boolean error, String mensaje) {
        this.error = error;
        this.mensaje = mensaje;
    }
    
    public boolean isError() {
        return error;
    }
    
    public void setError(boolean error) {
        this.error = error;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public User getEmpleado() {
        return empleado;
    }
    
    public void setEmpleado(User empleado) {
        this.empleado = empleado;
    }
    
    public List<User> getLista() {
        return lista;
    }
    
    public void setLista(List<User> lista) {
        this.lista = lista;
    }

    public SesionToken getSesiontoken() {
        return sesiontoken;
    }

    public void setSesiontoken(SesionToken sesiontoken) {
        this.sesiontoken = sesiontoken;
    }
}
