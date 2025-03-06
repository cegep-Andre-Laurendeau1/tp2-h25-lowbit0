package ca.cal.tp2.repo;

import ca.cal.tp2.modele.Utilisateur;

public interface UtilisateurRepository {
    public void save(Utilisateur utilisateur);

    public Utilisateur getUtilisateurById(int id);
}
