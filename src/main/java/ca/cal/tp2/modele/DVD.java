package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorColumn(name = "DVD")
@ToString
@Getter
@Setter
public class DVD extends Document {
    private String director;
    private int duree;
    private String rating;

    @Override
    public void verifieDisponibilite() {

        System.out.println("Vérification de la disponibilité du DVD : " + getTitre());
    }
}