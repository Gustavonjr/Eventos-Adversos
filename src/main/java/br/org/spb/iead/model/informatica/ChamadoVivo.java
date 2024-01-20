package br.org.spb.iead.model.informatica;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TB_CHAMADOVIVO")
public class ChamadoVivo {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chamdoID;

    @NotBlank(message = "O texto é obrigatório")
    private String maquina;

    @NotBlank(message = "O texto é obrigatório")
    private String protocolo;

    @NotBlank(message = "O texto é obrigatório")
    private String observacao;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate dataAbertura;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate dataFechamento;



}
