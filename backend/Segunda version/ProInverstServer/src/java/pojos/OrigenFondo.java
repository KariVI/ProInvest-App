
package pojos;


public class OrigenFondo {
    private Integer idOrigenFondo;
    private String origen;

    public OrigenFondo(String origen) {
        this.origen = origen;
    }

    public OrigenFondo(Integer idOrigenFondo, String origen) {
        this.idOrigenFondo = idOrigenFondo;
        this.origen = origen;
    }

    public Integer getIdOrigenFondo() {
        return idOrigenFondo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setIdOrigenFondo(Integer idOrigenFondo) {
        this.idOrigenFondo = idOrigenFondo;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    
    
}
