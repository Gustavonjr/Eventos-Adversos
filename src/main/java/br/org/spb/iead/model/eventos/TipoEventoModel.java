package br.org.spb.iead.model.eventos;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_TIPO_EVENTO")
public class TipoEventoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String tipoEvento;

    public TipoEventoModel(){

    }
    public TipoEventoModel(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
}
