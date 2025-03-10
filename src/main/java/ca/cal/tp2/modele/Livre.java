package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.ToString;

@Entity
@DiscriminatorValue("LIVRE")
@ToString
@Getter
public class Livre extends Document {
    private String ISBN;
    private String auteur;
    private String editeur;
    private int nombrePages;

    @Override
    public void verifieDisponibilite() {
        System.out.println("ISBN: " + ISBN);
    }
}


