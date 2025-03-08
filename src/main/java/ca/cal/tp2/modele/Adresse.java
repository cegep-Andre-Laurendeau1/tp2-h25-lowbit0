package ca.cal.tp2.modele;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@ToString
@Setter
@Getter
@NoArgsConstructor
public class Adresse {
    private String rue;
    private String civic;
    private String codePostal;
    private String ville;
    private String province;
    private String pay;

    public Adresse(String adresseComplet) {
        String[] morseauString = adresseComplet.split(",");
        this.rue = morseauString[0].trim();
        this.civic = morseauString[1].trim();
        this.codePostal = morseauString[2].trim();
        this.ville = morseauString[3].trim();
        this.province = morseauString[4].trim();
        this.pay = morseauString[5].trim();
    }

    public String toSingleString() {
        return rue + "," + civic + "," + codePostal + "," + ville + "," + province + "," + pay;
    }
}
