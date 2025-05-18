package org.example.backendspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Setter
@Getter
@Entity
public class budget {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
   @Column
    private double montant;
    @Column
    private String Enum;
    @Column
    private Date date;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getenumValue() {
        return Enum;
    }

    public void setenumValue(String anEnum) {
        Enum = anEnum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public budget(Long id, double montant, String anEnum, Date date) {
        this.id = id;
        this.montant = montant;
        Enum = anEnum;
        this.date = date;
    }

    public budget() {
    }

    @Override
    public String toString() {
        return "budget{" +
                "id=" + id +
                ", montant=" + montant +
                ", Enum='" + Enum + '\'' +
                ", date=" + date +
                '}';
    }
}
