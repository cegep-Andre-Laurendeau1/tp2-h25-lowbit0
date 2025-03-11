package ca.cal.tp2.service;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.*;
import ca.cal.tp2.repo.EmpruntDetailRepository;
import ca.cal.tp2.repo.EmpruntRepository;
import ca.cal.tp2.repo.UtilisateurRepository;
import ca.cal.tp2.service.dto.EmprunteurDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprunteurService {
    private final UtilisateurRepository repositoryUtilisateur;
    private final EmpruntRepository repositoryEmprunt;
    private final EmpruntDetailRepository repositoryEmpruntDetail;


    public EmprunteurService(UtilisateurRepository repository, EmpruntRepository repositoryEmprunt, EmpruntDetailRepository repositoryEmpruntDetail) {
        this.repositoryUtilisateur = repository;
        this.repositoryEmprunt = repositoryEmprunt;
        this.repositoryEmpruntDetail = repositoryEmpruntDetail;
    }


    public void createEmprunteur(Utilisateur utilisateur) throws DataBaseException {
        repositoryUtilisateur.save(utilisateur);
    }

    public EmprunteurDTO getEmprunteurById(int id) throws DataBaseException {
        Utilisateur utilisateur = repositoryUtilisateur.getUtilisateurById(id);
        if (utilisateur instanceof Emprunteur) {
            return EmprunteurDTO.toDTO(utilisateur);
        }
        return null;
    }

    public EmprunteurDTO getEmprunteurByMail(String email) throws DataBaseException {
        Utilisateur utilisateur = repositoryUtilisateur.getUtilisateurByMail(email);
        if (utilisateur instanceof Emprunteur) {
            return EmprunteurDTO.toDTO(utilisateur);
        }
        return null;
    }


    // ------------------------ section Emprunt ----------------------

    public void createEmprunt(  List<Document> documents, Emprunteur emprunteur) throws DataBaseException {
        Emprunt emprunt = new Emprunt();
        emprunt.setDateEmprunt(LocalDate.now());
        emprunt.setStatus("Actif");
        emprunt.setEmprunteur(emprunteur);

        List<EmpruntDetail> empruntDetails = new ArrayList<>();
        for (Document document : documents) {
            EmpruntDetail empruntDetail = new EmpruntDetail();
            empruntDetail.setDateRetourPrevue(dateRetourPrevu(document, emprunt.getDateEmprunt()));
            empruntDetail.setDocument(document);
            empruntDetail.setEmprunt(emprunt);
            empruntDetails.add(empruntDetail);
            empruntDetail.setStatus("Empunte");

            EmpruntDetailId empruntDetailId = new EmpruntDetailId();
            empruntDetailId.setEmpruntId(emprunt.getId());
            empruntDetailId.setDocumentId(document.getId());
            empruntDetail.setId(empruntDetailId);

        }
        emprunt.setEmpruntDetail(empruntDetails);
        repositoryEmprunt.saveEmprunt(emprunt);


    }

    public LocalDate dateRetourPrevu(Document document, LocalDate dateEmprunt) {
        int dureeEmprunt = document.getDureeEmprunt();
        return dateEmprunt.plusDays(dureeEmprunt);
    }


}

