package ca.cal.tp2.repo;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Utilisateur;

public interface UtilisateurRepository {
    public void save(Utilisateur utilisateur) throws DataBaseException;

    public Utilisateur getUtilisateurById(int id)throws DataBaseException;

    Utilisateur getUtilisateurByMail(String email)throws DataBaseException;

}
