package ca.cal.tp2.modele;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
    public String rue;
    public String codePostal;
    public String ville;
    public String province;
    public String Pay;

}
