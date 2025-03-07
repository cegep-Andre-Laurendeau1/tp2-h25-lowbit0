package ca.cal.tp2.modele;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_DOCUMENT", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titre;




    public void verifieDisponibilite() {}
}
