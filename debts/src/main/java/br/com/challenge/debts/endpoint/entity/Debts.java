package br.com.challenge.debts.endpoint.entity;

import br.com.challenge.core.listener.PreventAnyUpdate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "debts")
@Getter
@EntityListeners(PreventAnyUpdate.class)
public class Debts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private Double value;

    @Column(name = "collectingcompanyid")
    private Long collectingCompanyId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "personid")
    private Person person;

}
