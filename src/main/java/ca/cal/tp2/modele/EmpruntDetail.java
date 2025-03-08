package ca.cal.tp2.modele;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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


    @ManyToOne
    @MapsId("documentId")
    private Document document;

    @ManyToOne
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
