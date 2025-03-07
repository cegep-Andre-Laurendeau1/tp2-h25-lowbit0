package ca.cal.tp2.modele;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Setter
@Getter
public class EmpruntDetailId implements Serializable {
    private int empruntId;
    private int documentId;
}
