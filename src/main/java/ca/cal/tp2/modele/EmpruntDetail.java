package ca.cal.tp2.modele;
import lombok.Data;
import java.util.Date;

@Data
public class EmpruntDetail {
    private final int id;
    private final Date dateRetourPrevue;
    private final Date dateRetourActuelle;
    private final String status;
    private Document document;

    public boolean isEnRetard() {
        if (dateRetourActuelle != null && dateRetourPrevue != null) {
            return dateRetourActuelle.after(dateRetourPrevue);
        }
        return false;
    }


    public double calculAmende() {
        return 0.0;
    }


    public void updateStatus(String newStatus) {
    }
}
