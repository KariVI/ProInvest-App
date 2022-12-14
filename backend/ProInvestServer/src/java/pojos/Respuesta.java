
package pojos;

import java.util.List;


public class Respuesta {
    private boolean error;
    private String mensaje;
    private User user;
    private List<User> lista;
    
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
        return user;
    }
    
    public void setEmpleado(User empleado) {
        this.user = empleado;
    }
    
    public List<User> getLista() {
        return lista;
    }
    
    public void setLista(List<User> lista) {
        this.lista = lista;
    }
}
