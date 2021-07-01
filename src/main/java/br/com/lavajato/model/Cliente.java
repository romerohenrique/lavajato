package br.com.lavajato.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "cliente", schema = "dbo_teste_lavajato")
public class Cliente implements Serializable {

    private static final long serialVersionUID = -5398800554640902699L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(nullable = false, length = 14)
    private String contato;

    @OneToMany
    private List<Veiculo> veiculoList;


}
