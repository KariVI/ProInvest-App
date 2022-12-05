/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.io.File;

/**
 *
 * @author carlosperezperez
 */
public class Expediente {
    private Integer idInversionista;
    private File pdf;
    
    public Expediente() {
        
    }
    
    public Expediente(Integer idInversionista, File pdf) {
        this.idInversionista = idInversionista;
    }

    public Integer getIdInversionista() {
        return idInversionista;
    }

    public void setIdInversionista(Integer idInversionista) {
        this.idInversionista = idInversionista;
    }

    public File getPdf() {
        return pdf;
    }

    public void setPdf(File pdf) {
        this.pdf = pdf;
    }
}
