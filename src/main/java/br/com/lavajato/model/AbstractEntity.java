package br.com.lavajato.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {
    private static final long serialVersionUID = 5780844516651267257L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

}
