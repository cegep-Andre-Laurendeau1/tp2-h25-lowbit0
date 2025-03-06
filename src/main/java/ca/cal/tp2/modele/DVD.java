package ca.cal.tp2.modele;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
public class DVD extends Document {
    private String director;
    private int duree;
    private String rating;

    @Override
    public void verifieDisponibilite() {

        System.out.println("Vérification de la disponibilité du DVD : " + getTitre());
    }
}