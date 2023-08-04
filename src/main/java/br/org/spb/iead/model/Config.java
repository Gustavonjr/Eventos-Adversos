package br.org.spb.iead.model;

import br.org.spb.iead.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_CONFIG")
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nomeSite;

//    @NotNull
//    @Lob
//    private byte[] logo;
    private String hostEmail;
    private int portaEmail;
    private String usuarioEmail;
    private String senhaEmail;
    private String destinatariEmail;

    public Config(){

    }
    public Config(String nomeSite, String hostEmail, int portaEmail, String usuarioEmail, String senhaEmail, String destinatariEmail) {
        this.nomeSite = nomeSite;
        this.hostEmail = hostEmail;
        this.portaEmail = portaEmail;
        this.usuarioEmail = usuarioEmail;
        this.senhaEmail = senhaEmail;
        this.destinatariEmail = destinatariEmail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeSite() {
        return nomeSite;
    }

    public void setNomeSite(String nomeSite) {
        this.nomeSite = nomeSite;
    }
//    public byte[] getLogo() {
//        return logo;
//    }
//
//    public void setLogo(byte[] logo) {
//        this.logo = logo;
//    }

    public String getHostEmail() {
        return hostEmail;
    }

    public void setHostEmail(String hostEmail) {
        this.hostEmail = hostEmail;
    }

    public int getPortaEmail() {
        return portaEmail;
    }

    public void setPortaEmail(int portaEmail) {
        this.portaEmail = portaEmail;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getSenhaEmail() {
        return senhaEmail;
    }

    public void setSenhaEmail(String senhaEmail) {
        this.senhaEmail = senhaEmail;
    }

    public String getDestinatariEmail() {
        return destinatariEmail;
    }

    public void setDestinatariEmail(String destinatariEmail) {
        this.destinatariEmail = destinatariEmail;
    }
}
