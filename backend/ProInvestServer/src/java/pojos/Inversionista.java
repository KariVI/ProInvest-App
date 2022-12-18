/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.Date;

/**
 *
 * @author carlosperezperez
 */
public class Inversionista {
    private Integer idInversionista;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String celular;
    private String direccionip;
    private Date fechaNacimiento;
    private String nombre;
    private String rfc;
    private String profesion;
    private Integer idGradoAcademico;
    private Integer idUsuario;

    public Inversionista() {
        
    }

    public Inversionista(String apellidoPaterno, String apellidoMaterno, String celular, String direccionip, Date fechaNacimiento, String nombre, String rfc, String profesion, Integer idGradoAcademico, Integer idUsuario) {
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.celular = celular;
        this.direccionip = direccionip;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.rfc = rfc;
        this.profesion = profesion;
        this.idGradoAcademico = idGradoAcademico;
        this.idUsuario = idUsuario;
    }
    
    

    public Integer getIdInversionista() {
        return idInversionista;
    }

    public void setIdInversionista(Integer idInversionista) {
        this.idInversionista = idInversionista;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccionip() {
        return direccionip;
    }

    public void setDireccionip(String direccionip) {
        this.direccionip = direccionip;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Integer getIdGradoAcademico() {
        return idGradoAcademico;
    }

    public void setIdGradoAcademico(Integer idGradoAcademico) {
        this.idGradoAcademico = idGradoAcademico;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
