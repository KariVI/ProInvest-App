
package pojos;


public class Direccion {
    private Integer idDireccion;
    private String calle;
    private Integer numeroExterior;
    private Integer numeroInterior;
    private Integer idDatoSepomex;
    private Integer idInversionista;
    
    public Direccion() {
        
    }

    public Direccion(String calle, Integer numeroExterior, Integer numeroInterior) {
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
    }

    public Direccion(String calle, Integer numeroExterior, Integer numeroInterior, Integer idDatoSepomex, Integer idInversionista) {
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.idDatoSepomex = idDatoSepomex;
        this.idInversionista = idInversionista;
    }
    
    

    public String getCalle() {
        return calle;
    }

    public Integer getNumeroExterior() {
        return numeroExterior;
    }

    public Integer getNumeroInterior() {
        return numeroInterior;
    }

    public Integer getIdDatoSepomex() {
        return idDatoSepomex;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumeroExterior(Integer numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public void setNumeroInterior(Integer numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public void setIdDatoSepomex(Integer idDatoSepomex) {
        this.idDatoSepomex = idDatoSepomex;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public Integer getIdInversionista() {
        return idInversionista;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public void setIdInversionista(Integer idInversionista) {
        this.idInversionista = idInversionista;
    }
}
