package br.com.challenge.consultcpf.endpoint.entity;


import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
public class PurchaseHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "company", length = 14)
    private String cpnj;

    @Column(name = "value")
    private Double value;

    @ManyToOne
    @JoinColumn(name = "personid")
    private Person person;

    @Column(name = "PurchaseDate")
    private Date purchaseDate;
}
