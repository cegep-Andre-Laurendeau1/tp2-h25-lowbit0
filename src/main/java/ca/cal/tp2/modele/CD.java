package ca.cal.tp2.modele;

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
    private final int dureEmprunt = 3;
    private int dureeMinutes;
    private int nbMusiques;

    @Override
    public int getDureeEmprunt() {
        return dureEmprunt;
    }


    @Override
    public void verifieDisponibilite() {

        System.out.println("Vérification de la disponibilité du CD : " + getTitre());
    }
}
