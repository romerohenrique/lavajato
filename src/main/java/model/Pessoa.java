package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@Getter
@Setter
@MappedSuperclass
public class Pessoa {
    @Id
    private Integer id;
    private String nome;
    private String cpf;
    private String contato;


//    public Pessoa(Integer id, String nome, String contato, String cpf) {
//        this.id = id;
//        this.nome = nome;
//        this.contato = contato;
//        this.cpf = cpf;
//    }
//
//    public Pessoa() {
//
//    }
//
//    @Override
//    public String toString() {
//        return "Pessoa{" +
//                "id=" + id +
//                ", nome='" + nome + '\'' +
//                ", contato='" + contato + '\'' +
//                ", cpf='" + cpf + '\'' +
//                '}'+"\n";
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Pessoa pessoa = (Pessoa) o;
//        return Objects.equals(id, pessoa.id) && Objects.equals(cpf, pessoa.cpf);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, cpf);
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getCpf() {
//        return cpf;
//    }
//
//    public void setCpf(String cpf) {
//        this.cpf = cpf;
//    }
//
//    public String getContato() {
//        return contato;
//    }
//
//    public void setContato(String contato) {
//        this.contato = contato;
//    }
}
