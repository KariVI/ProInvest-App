/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author carlosperezperez
 */
public class SesionToken {
    private Integer id;
    private String email;
    private String tokenacceso;
    
    public SesionToken() {
        
    }
    
    public SesionToken(Integer id, String email, String tokenacceso) {
        this.id = id;
        this.email = email;
        this.tokenacceso = tokenacceso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTokenacceso() {
        return tokenacceso;
    }

    public void setTokenacceso(String tokenacceso) {
        this.tokenacceso = tokenacceso;
    }
}
