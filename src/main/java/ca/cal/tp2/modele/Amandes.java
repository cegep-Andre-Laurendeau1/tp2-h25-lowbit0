package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Amandes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double montant;
    private LocalDate dateCreation;
    @ManyToOne
    private Emprunteur emprunteur;

    public double calculMontant() {
       return 0;
    }


    public void updateStatus() {

    }

    public boolean status(double montant) {
        return false;
    }
}