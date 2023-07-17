package br.org.spb.iead.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "TB_EVENTO")
public class Evento {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Integer cracha;
    private String nomeColaborador;

    @NotBlank(message = "O texto é obrigatório")
    private boolean eventRelacPac;

    @NotBlank(message = "O texto é obrigatório")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate data;

    @NotBlank(message = "O texto é obrigatório")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime hora;

    @NotBlank(message = "O texto é obrigatório")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate dataSys;

    @NotBlank(message = "O texto é obrigatório")
    private String turno;

    @NotBlank(message = "O texto é obrigatório")
    private String setorOcorrencia;

    @NotBlank(message = "O texto é obrigatório")
    private String setorNotificante;

    @NotBlank(message = "O texto é obrigatório")
    private String classificacao;

    @NotBlank(message = "O texto é obrigatório")
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descricaoEvento;

    @NotBlank(message = "O texto é obrigatório")
    @Lob
    @Column(columnDefinition = "TEXT")
    private String acaoImediata;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getCracha() {
        return cracha;
    }

    public void setCracha(Integer cracha) {
        this.cracha = cracha;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public boolean isEventRelacPac() {
        return eventRelacPac;
    }

    public void setEventRelacPac(boolean eventRelacPac) {
        this.eventRelacPac = eventRelacPac;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getDataSys() {
        return dataSys;
    }

    public void setDataSys(LocalDate dataSys) {
        this.dataSys = dataSys;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSetorOcorrencia() {
        return setorOcorrencia;
    }

    public void setSetorOcorrencia(String setorOcorrencia) {
        this.setorOcorrencia = setorOcorrencia;
    }

    public String getSetorNotificante() {
        return setorNotificante;
    }

    public void setSetorNotificante(String setorNotificante) {
        this.setorNotificante = setorNotificante;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getAcaoImediata() {
        return acaoImediata;
    }

    public void setAcaoImediata(String acaoImediata) {
        this.acaoImediata = acaoImediata;
    }
}
