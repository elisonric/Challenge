package br.com.challenge.creditscore.endpoint.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
public class PersonProperty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private Double value;

    @Column(name = "type")
    private String type;

    @Column(name = "adress", nullable = true)
    private String adress;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "personid")
    private Person person;
}
