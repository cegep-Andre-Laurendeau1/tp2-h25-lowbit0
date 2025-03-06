package ca.cal.tp2.modele;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
public class Emprunteur extends Utilisateur {
    private final LocalDate dateInscription;
    private final int DureeInscription;

    private List<Emprunt> emprunts = new ArrayList<>();

    private List<Amandes> amendes = new ArrayList<>();

    @Override
    public String toString() {
        return "Emprunteur{" +
                "id=" + getId() +
                ", nom='" + getNom() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", adresse='" + getAdresse() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", dateInscription=" + dateInscription +
                ", DureeInscription=" + DureeInscription +
                '}';
    }
}
