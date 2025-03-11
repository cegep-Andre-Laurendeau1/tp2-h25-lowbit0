package ca.cal.tp2.modele;


import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Entity
@DiscriminatorValue("PREPOSE")
@ToString(callSuper = true)
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Prepose extends Utilisateur {
    private String poste;
    private LocalDate dateEmbauche;
    public void entreNouveauDocument(Document doc) {}
    public void collecteAmende(Emprunteur emprunteur, double montant) {}
    public String rapportAmendes(){
        return "";
    }
    public String rapportEmprunts(){
        return "";
    }

}
