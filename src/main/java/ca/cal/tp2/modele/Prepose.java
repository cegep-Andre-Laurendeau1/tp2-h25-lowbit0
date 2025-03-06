package ca.cal.tp2.modele;


import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@DiscriminatorColumn(name = "PEPOSE")
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
