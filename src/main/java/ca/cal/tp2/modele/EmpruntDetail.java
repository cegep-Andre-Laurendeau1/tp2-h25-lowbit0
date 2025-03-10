package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class EmpruntDetail {

    @EmbeddedId
    private EmpruntDetailId id;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourActuelle;
    private String status;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("documentId")
    private Document document;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("empruntId")
    private Emprunt emprunt;

    public boolean isEnRetard() {
        if (dateRetourActuelle != null && dateRetourPrevue != null) {
            return dateRetourActuelle.isAfter(dateRetourPrevue);
        }
        return false;
    }


    public double calculAmende() {
        return 0.0;
    }


    public void updateStatus(String newStatus) {
    }
}
