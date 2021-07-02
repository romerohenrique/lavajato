package br.com.lavajato.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "veiculo", schema = "lavajato")
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
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
