package ca.cal.tp2.modele;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Emprunt {
    private final int id;
    private final LocalDate dateEmprunt;
    private final String status;
    private EmpruntDetail[] empruntDetail;



    public  Emprunt getEmprunt(){
        return null;
    };

}
