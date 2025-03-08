package ca.cal.tp2.service;

import ca.cal.tp2.repo.UtilisateurRepository;

public class PreposeService {

    private final UtilisateurRepository utilisateurRepository;

    public PreposeService( UtilisateurRepository utilisateurRepository) {

        this.utilisateurRepository = utilisateurRepository;
    }

public void createUtilisateur(long id, String nom, String email, String phonNumber, String adresse , String password) {}



}
