package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorColumn(name = "Emprunteur")
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Emprunteur extends Utilisateur {
    private LocalDate dateInscription;
    private int DureeInscription;

    @OneToMany(mappedBy = "emprunteur")
    private List<Emprunt> emprunts = new ArrayList<>();

    @OneToMany(mappedBy = "emprunteur")
    private List<Amandes> amendes = new ArrayList<>();



}
