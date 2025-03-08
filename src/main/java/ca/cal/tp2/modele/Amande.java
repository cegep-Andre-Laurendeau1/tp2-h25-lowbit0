package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Amande {
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