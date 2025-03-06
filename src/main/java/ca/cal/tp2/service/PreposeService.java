package ca.cal.tp2.service;

import ca.cal.tp2.repo.DocumentRepository;
import ca.cal.tp2.repo.UtilisateurRepository;

public class PreposeService {
    private final DocumentRepository documentRepository;
    private final UtilisateurRepository utilisateurRepository;

    public PreposeService(DocumentRepository documentRepository, UtilisateurRepository utilisateurRepository) {
        this.documentRepository = documentRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

public void createUtilisateur(long id, String nom, String email, String phonNumber, String adresse , String password) {}



}
