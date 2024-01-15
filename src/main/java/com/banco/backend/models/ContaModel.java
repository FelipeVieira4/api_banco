package com.banco.backend.models;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity()
@Table(name = "conta_table")
public class ContaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Gerar ID tipo auto_increment
    private int id;

    @Column(name = "saldo")
    private float saldo;

    @ManyToOne()
    @JoinColumn(name="clienteID")
    private ClienteModel clienteId;

}
