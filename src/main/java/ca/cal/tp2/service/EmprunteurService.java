package ca.cal.tp2.service;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Utilisateur;
import ca.cal.tp2.repo.UtilisateurRepository;
import ca.cal.tp2.service.dto.UtilisateurDTO;

public class EmprunteurService {
    private final UtilisateurRepository repositoryUtilisateur;

    public EmprunteurService(UtilisateurRepository repository) {
        this.repositoryUtilisateur = repository;
    }

    public void createEmprunteur(Utilisateur utilisateur) throws DataBaseException {
        repositoryUtilisateur.save(utilisateur);
    }

    public UtilisateurDTO getEmprunteur(int id) throws DataBaseException {
        Utilisateur utilisateur = repositoryUtilisateur.getUtilisateurById(id);
        if (utilisateur instanceof Emprunteur) {
            return mapToDTO(utilisateur);
        }
        return null;
    }

    public UtilisateurDTO getEmprunteurByMail(String email) throws DataBaseException {
        Utilisateur utilisateur = repositoryUtilisateur.getUtilisateurByMail(email);
        if (utilisateur instanceof Emprunteur) {
            return mapToDTO(utilisateur);
        }
        return null;
    }

    private UtilisateurDTO mapToDTO(Utilisateur utilisateur) {
        return new UtilisateurDTO(
                utilisateur.getId(),
                utilisateur.getNom(),
                utilisateur.getEmail(),
                utilisateur.getPhoneNumber(),
                utilisateur.getAdresse(),
                utilisateur.getPassword()
        );
    }
}

