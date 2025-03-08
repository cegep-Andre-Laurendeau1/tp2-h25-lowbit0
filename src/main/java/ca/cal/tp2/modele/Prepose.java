package ca.cal.tp2.modele;


import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Entity
@DiscriminatorColumn(name = "PEPOSE")
@ToString
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Prepose extends Utilisateur {
    private String poste;
    private LocalDate dateInscription;
    public void entreNouveauDocument(Document doc) {}
    public void collecteAmende(Emprunteur emprunteur, double montant) {}
    public String rapportAmendes(){
        return "";
    }
    public String rapportEmprunts(){
        return "";
    }

}
