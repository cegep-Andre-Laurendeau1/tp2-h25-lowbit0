package ca.cal.tp2.modele;


import lombok.Data;

@Data
public abstract class Document {

    private final int id;
    private final String titre;
    private Prepose prepose;

    public void verifieDisponibilite() {}
}
