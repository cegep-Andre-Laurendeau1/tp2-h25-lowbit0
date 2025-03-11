package ca.cal.tp2.modele;

import jakarta.persistence.CascadeType;
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
@ToString(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Emprunteur extends Utilisateur {
    private LocalDate dateInscription;
    private int dureeInscription;

    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Emprunt> emprunts = new ArrayList<>();

    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Amande> amendes = new ArrayList<>();
}
