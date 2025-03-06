package ca.cal.tp2.modele;

import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_UTILISATEUR")
public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String email;
    private String phoneNumber;

    @Embedded
    private Adresse adresse;
    private String password;

    public void login(){}


}
