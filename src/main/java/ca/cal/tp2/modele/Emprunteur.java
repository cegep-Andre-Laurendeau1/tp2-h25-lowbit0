package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Emprunteur")
@ToString
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class Emprunteur extends Utilisateur {
    private LocalDate dateInscription;
    private int DureeInscription;

    @OneToMany(mappedBy = "emprunteur")
    private List<Emprunt> emprunts = new ArrayList<>();

    @OneToMany(mappedBy = "emprunteur")
    private List<Amande> amendes = new ArrayList<>();
}
