package br.org.spb.iead.model.eventos;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_PROBLEMA")
public class ProblemaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String problema;


    @ManyToOne
    private ProcessoModel processo;


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

    public ProcessoModel getProcesso() {
        return processo;
    }

    public void setProcesso(ProcessoModel procsso) {
        this.processo = procsso;
    }
}
