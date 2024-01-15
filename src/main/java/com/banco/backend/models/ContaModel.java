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
    private ClienteModel clienteID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public ClienteModel getClienteID() {
        return clienteID;
    }

    public void setClienteID(ClienteModel clienteID) {
        this.clienteID = clienteID;
    }
}
