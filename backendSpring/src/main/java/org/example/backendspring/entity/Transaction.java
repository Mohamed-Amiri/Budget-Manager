package org.example.backendspring.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Transaction {

    @Id
    private int id;


    @Column
    private double Montant;

    @Column
    private Date date;

    @Column
    private String Description;

    @Column
    private String Type ;

    @Column
    private String label;

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;

    public double getMontant() {
        return Montant;
    }

    public void setMontant(double montant) {
        Montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
