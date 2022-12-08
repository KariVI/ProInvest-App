/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author carlosperezperez
 */
public class Direccion {
    private String calle;
    private Integer numeroExterior;
    private Integer numeroInterior;
    private Integer idDatoSepomex;
    
    public Direccion() {
        
    }

    public Direccion(String calle, Integer numeroExterior, Integer numeroInterior) {
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
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
}
