package br.org.spb.iead.model.eventos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_OBSERVACAO")
public class ObservacaoEvento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String observacao;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "evento_id")
    private Evento evento;

    private LocalDateTime dataObservacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public LocalDateTime getDataObservacao() {
        return dataObservacao;
    }

    public void setDataObservacao(LocalDateTime dataObservacao) {
        this.dataObservacao = dataObservacao;
    }


}
