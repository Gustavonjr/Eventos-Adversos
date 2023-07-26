package br.org.spb.iead.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_PROBLEMA")
public class Problema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String problema;


    @ManyToOne
    private Processo processo;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo procsso) {
        this.processo = procsso;
    }
}
