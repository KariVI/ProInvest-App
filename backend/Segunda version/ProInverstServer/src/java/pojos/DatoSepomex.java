
package pojos;


public class DatoSepomex {
    private Integer idDatoSepomex;
    private String estado;
    private String municipio;
    private String colonia;
    private Integer cp;

    public DatoSepomex(Integer idDatoSepomex, String estado, String municipio, String colonia, Integer cp) {
        this.idDatoSepomex = idDatoSepomex;
        this.estado = estado;
        this.municipio = municipio;
        this.colonia = colonia;
        this.cp = cp;
    }

    public DatoSepomex() {
       
    }

    public Integer getIdDatoSepomex() {
        return idDatoSepomex;
    }

    public String getEstado() {
        return estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public Integer getCp() {
        return cp;
    }

    public void setIdDatoSepomex(Integer idDatoSepomex) {
        this.idDatoSepomex = idDatoSepomex;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    
}
