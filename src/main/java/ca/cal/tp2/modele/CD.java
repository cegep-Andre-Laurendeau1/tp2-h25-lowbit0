package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.ToString;



@Entity
@DiscriminatorValue("CD")
@ToString
@Getter
public class CD extends Document {
    private String artiste;
    private int duree;
    private String genre;

    @Override
    public void verifieDisponibilite() {

        System.out.println("Vérification de la disponibilité du CD : " + getTitre());
    }
}
