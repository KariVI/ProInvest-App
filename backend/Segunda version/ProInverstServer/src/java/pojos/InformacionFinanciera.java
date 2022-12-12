/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author carlosperezperez
 */
public class InformacionFinanciera {
    private Integer idInformacionFinanciera;
    private Integer idBanco;
    private String clabe;
    private String cuenta;
    private Integer idOrigenFondo;

    public InformacionFinanciera(Integer idInformacionFinanciera, Integer idBanco, String clabe, String cuenta, Integer idOrigenFondo) {
        this.idInformacionFinanciera = idInformacionFinanciera;
        this.idBanco = idBanco;
        this.clabe = clabe;
        this.cuenta = cuenta;
        this.idOrigenFondo = idOrigenFondo;
    }

    public InformacionFinanciera(Integer idBanco, String clabe, String cuenta, Integer idOrigenFondo) {
        this.idBanco = idBanco;
        this.clabe = clabe;
        this.cuenta = cuenta;
        this.idOrigenFondo = idOrigenFondo;
    }

    public Integer getIdInformacionFinanciera() {
        return idInformacionFinanciera;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public String getClabe() {
        return clabe;
    }

    public String getCuenta() {
        return cuenta;
    }

    public Integer getIdOrigenFondo() {
        return idOrigenFondo;
    }

    public void setIdInformacionFinanciera(Integer idInformacionFinanciera) {
        this.idInformacionFinanciera = idInformacionFinanciera;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public void setIdOrigenFondo(Integer idOrigenFondo) {
        this.idOrigenFondo = idOrigenFondo;
    }
    
}
