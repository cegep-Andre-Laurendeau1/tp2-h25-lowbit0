package ca.cal.tp2.repo;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Emprunt;

public interface EmpruntRepository {
    public void saveEmprunt(Emprunt emprunt) throws DataBaseException;



}
