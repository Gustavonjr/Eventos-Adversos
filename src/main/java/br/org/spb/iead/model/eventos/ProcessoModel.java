package br.org.spb.iead.model.eventos;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_PROCESSO")
public class ProcessoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String processo;


    @ManyToOne
    private TipoEventoModel tipoEvento;


    public ProcessoModel(){

    }

    public ProcessoModel(String processo) {
        this.processo = processo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public TipoEventoModel getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEventoModel tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
}
