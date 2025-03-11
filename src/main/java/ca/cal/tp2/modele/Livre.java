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
@DiscriminatorValue("LIVRE")
@ToString(callSuper = true)
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Livre extends Document {
    private String ISBN;
    private String auteur;
    private String editeur;
    private int nbPages;

    @Override
    public void verifieDisponibilite() {
        System.out.println("ISBN: " + ISBN);
    }
}


