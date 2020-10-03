package br.com.challenge.consultcpf.endpoint.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
public class FinalcialMoviment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private Double value;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "personid")
    private Person person;
}
