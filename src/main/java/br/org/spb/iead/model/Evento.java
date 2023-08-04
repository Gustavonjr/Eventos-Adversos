package br.org.spb.iead.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "TB_EVENTO")
public class Evento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    private SetorModel setorOcorrencia;

    @ManyToOne
    private SetorModel setorNotificante;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate dataClassificacaoUpdate;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
    private LocalTime horaClassificacaoUpdate;

    private String nomePaciente;
    private String numeroAtendimento;

    @ManyToOne
    private Problema problema;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<ObservacaoEvento> observacao;


    // DAQUI PRA BAIXO É SO METODO ==========================
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

    public Problema getProblema() {
        return problema;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
    }

    public LocalDate getDataClassificacaoUpdate() {
        return dataClassificacaoUpdate;
    }

    public void setDataClassificacaoUpdate(LocalDate dataClassificacaoUpdate) {
        this.dataClassificacaoUpdate = dataClassificacaoUpdate;
    }

    public LocalTime getHoraClassificacaoUpdate() {
        return horaClassificacaoUpdate;
    }

    public void setHoraClassificacaoUpdate(LocalTime horaClassificacaoUpdate) {
        this.horaClassificacaoUpdate = horaClassificacaoUpdate;
    }

    public SetorModel getSetorOcorrencia() {
        return setorOcorrencia;
    }

    public void setSetorOcorrencia(SetorModel setorOcorrencia) {
        this.setorOcorrencia = setorOcorrencia;
    }

    public SetorModel getSetorNotificante() {
        return setorNotificante;
    }

    public void setSetorNotificante(SetorModel setorNotificante) {
        this.setorNotificante = setorNotificante;
    }

    public List<ObservacaoEvento> getObservacao() {
        return observacao;
    }
}
