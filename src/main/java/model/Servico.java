package model;


import java.util.Objects;

public class Servico {

    private long idServico;
    private Integer tipoServico;
    private long idCliente;
    private long idVeiculo;


    public Servico(long idServico, long idCliente, long idVeiculo, Integer tipoServico) {
        this.idServico = idServico;
        this.idCliente = idCliente;
        this.idVeiculo = idVeiculo;
        this.tipoServico = tipoServico;
    }

    public long getIdServico() {
        return idServico;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public long getIdVeiculo() {
        return idVeiculo;
    }

    public Integer getTipoServico() {
        return tipoServico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return idServico == servico.idServico && idCliente == servico.idCliente && idVeiculo == servico.idVeiculo && Objects.equals(tipoServico, servico.tipoServico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServico, idCliente, idVeiculo, tipoServico);
    }

    @Override
    public String toString() {
        return "Servico{" +
                "idServico=" + idServico +
                ", idCliente=" + idCliente +
                ", idVeiculo=" + idVeiculo +
                ", tipoServico=" + tipoServico +
                '}';
    }
}
