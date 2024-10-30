package com.consuptiom.crud.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // garante que a classe seja tratada como uma entidade, ou seja, cada campo é uma coluna
@Table(name = "pessoas") // nome da tabela onde as informações serão guardadas
public class PessoaModel {
    @Id // informa que esse atributo é o ID (primary key)
    @GeneratedValue(strategy = GenerationType.AUTO) // gera o ID automaticamente
    private Integer id;
    private String name;
    private String description;
}
