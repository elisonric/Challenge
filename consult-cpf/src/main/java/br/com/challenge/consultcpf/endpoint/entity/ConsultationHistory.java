package br.com.challenge.consultcpf.endpoint.entity;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
public class ConsultationHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "consultationDate")
    private Date consultationDate;

    @ManyToOne
    @JoinColumn(name = "personid")
    private Person person;

}
