package ca.cal.tp2.modele;


import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDate;


@Entity
@DiscriminatorColumn(name = "PEPOSE")
@ToString
@Getter
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
