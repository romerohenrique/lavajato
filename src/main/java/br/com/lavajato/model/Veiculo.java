package br.com.lavajato.model;

import lombok.Data;

import javax.persistence.Entity;
@Data
@Entity
public class Veiculo extends AbstractEntity {

    private static final long serialVersionUID = -1456376792898670929L;
    private String marca;
    private String modelo;
    private String placa;
    private Cliente cliente;

//
//    public Veiculo(Integer id, String marca, String modelo, String placa, Cliente cliente) {
//        this.id = id;
//        this.marca = marca;
//        this.modelo = modelo;
//        this.placa = placa;
//        this.cliente = cliente;
//    }
//

//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getMarca() {
//        return marca;
//    }
//
//    public void setMarca(String marca) {
//        this.marca = marca;
//    }
//
//    public String getModelo() {
//        return modelo;
//    }
//
//    public void setModelo(String modelo) {
//        this.modelo = modelo;
//    }
//
//    public String getPlaca() {
//        return placa;
//    }
//
//    public void setPlaca(String placa) {
//        this.placa = placa;
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//    @Override
//    public String toString() {
//        return "Veiculo{" +
//                "id=" + id +
//                ", marca='" + marca + '\'' +
//                ", modelo='" + modelo + '\'' +
//                ", placa='" + placa + '\'' +
//                ", cliente=" + cliente +
//                '}';
//    }
}
