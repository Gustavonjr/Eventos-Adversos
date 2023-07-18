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
    private String eventRelacPac;

    @NotBlank(message = "A hora é obrigatória")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private String data;

    @NotBlank(message = "A hora é obrigatória")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private String hora;

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

    private String resolvido;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate dataResolvidoUpdate;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
    private LocalTime horaResolvidoUpdate;

    private String nomePaciente;
    private String numeroAtendimento;

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

    public String getEventRelacPac() {
        return eventRelacPac;
    }

    public void setEventRelacPac(String eventRelacPac) {
        this.eventRelacPac = eventRelacPac;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
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

    public String getResolvido() {
        return resolvido;
    }

    public void setResolvido(String resolvido) {
        this.resolvido = resolvido;
    }

    public LocalDate getDataResolvidoUpdate() {
        return dataResolvidoUpdate;
    }

    public void setDataResolvidoUpdate(LocalDate dataResolvidoUpdate) {
        this.dataResolvidoUpdate = dataResolvidoUpdate;
    }

    public LocalTime getHoraResolvidoUpdate() {
        return horaResolvidoUpdate;
    }

    public void setHoraResolvidoUpdate(LocalTime horaResolvidoUpdate) {
        this.horaResolvidoUpdate = horaResolvidoUpdate;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNumeroAtendimento() {
        return numeroAtendimento;
    }

    public void setNumeroAtendimento(String numeroAtendimento) {
        this.numeroAtendimento = numeroAtendimento;
    }
}
