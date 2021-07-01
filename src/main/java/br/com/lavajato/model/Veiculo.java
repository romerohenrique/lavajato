package br.com.lavajato.model;

import lombok.*;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.StackManipulation;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "veiculo", schema = "dbo_teste_lavajato")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = -7069327751173158359L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(max = 30, message = "Máximo 30 caracteres")
    @Column(nullable = false, length = 30)
    private String marca;

    @Size(max = 30, message = "Máximo 30 caracteres")
    @Column(nullable = false, length = 30)
    private String modelo;

    @Size(max = 9, message = "Máximo 9 caracteres")
    @Column(length = 9)
    @NonNull
    private String placa;

    @ManyToOne
    private Cliente cliente;
}
