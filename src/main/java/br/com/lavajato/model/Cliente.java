package br.com.lavajato.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
@Data
@AllArgsConstructor
@Entity
public class Cliente extends Pessoa {

    private static final long serialVersionUID = -350651755304127661L;
}
