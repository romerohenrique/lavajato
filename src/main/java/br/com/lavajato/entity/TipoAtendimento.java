package br.com.lavajato.entity;


import br.com.lavajato.enums.TipoAtendimentoEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "tipos_atendimentos", schema = "lavajato")
public class TipoAtendimento implements Serializable {

    private static final long serialVersionUID = -1885418649130275842L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idServico;

    @Column(name = "tipo_atendimento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoAtendimentoEnum tipoAtendimentoEnum;

    @Column(name = "cliente_id", nullable = false)
    private Integer idCliente;

    @Column(name = "veiculo_id", nullable = false)
    private Integer idVeiculo;

}
