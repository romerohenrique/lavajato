package br.com.lavajato.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Pessoa extends AbstractEntity {

    private static final long serialVersionUID = -4175186417952686976L;
    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(nullable = false, length = 14)
    private String contato;
}
