/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author carlosperezperez
 */
public class Inversion {
    private double importe;
    private Integer plazo;
    private double tasaRetorno;
    private String tipo;
    
    public Inversion() {
        
    }
    
    public Inversion(double importe, Integer plazo, double tasaRetorno, String tipo) {
        this.importe = importe;
        this.plazo = plazo;
        this.tasaRetorno = tasaRetorno;
        this.tipo = tipo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public double getTasaRetorno() {
        return tasaRetorno;
    }

    public void setTasaRetorno(double tasaRetorno) {
        this.tasaRetorno = tasaRetorno;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
