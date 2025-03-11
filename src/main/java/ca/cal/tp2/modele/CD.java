package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@DiscriminatorValue("CD")
@ToString(callSuper = true)
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CD extends Document {
    private String artiste;
    private int duree;


    @Override
    public void verifieDisponibilite() {

        System.out.println("Vérification de la disponibilité du CD : " + getTitre());
    }
}
