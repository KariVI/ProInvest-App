
package pojos;


public class Banco {
    private Integer idBanco;
    private String nombre;
    
    public Banco(){
        
    }

    public Banco(Integer idBanco, String nombre) {
        this.idBanco = idBanco;
        this.nombre = nombre;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
