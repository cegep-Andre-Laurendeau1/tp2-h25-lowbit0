package ca.cal.tp2.service;

import ca.cal.tp2.modele.Utilisateur;
import ca.cal.tp2.repo.UtilisateurRepository;

public class EmprunteurService {
    private final UtilisateurRepository repositoryUtilisateur;

    public EmprunteurService(UtilisateurRepository repository) {
        this.repositoryUtilisateur = repository;
    }

    public void createEmprunteur(Utilisateur utilisateur) {
    repositoryUtilisateur.save(utilisateur);}
    public Utilisateur getEmprunteur(int id) {return repositoryUtilisateur.getUtilisateurById(id);}
}
