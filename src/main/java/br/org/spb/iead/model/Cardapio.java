package br.org.spb.iead.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cardapio {

    //TODO verificar com a equipe de nutrição a questão do cardapio se existe a necessidade da aplicação
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCardapio;

    private String arrozBranco;
    private String feijaoCarioca;
    private String pratoPrincipal;
    private String guarnicao;
    private String sobremesa;
    private String suco;
    private String opcao;
}
