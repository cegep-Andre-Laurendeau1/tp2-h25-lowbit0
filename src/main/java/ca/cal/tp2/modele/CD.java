package ca.cal.tp2.modele;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
public class CD extends Document {
    private String artiste;
    private int duree;
    private String genre;

    @Override
    public void verifieDisponibilite() {

        System.out.println("Vérification de la disponibilité du CD : " + getTitre());
    }
}
