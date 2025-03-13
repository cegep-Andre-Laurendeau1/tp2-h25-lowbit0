package ca.cal.tp2.service;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Prepose;
import ca.cal.tp2.modele.Utilisateur;
import ca.cal.tp2.repo.DocumentRepository;
import ca.cal.tp2.repo.EmpruntDetailRepository;
import ca.cal.tp2.repo.UtilisateurRepository;
import ca.cal.tp2.service.dto.DocumentDTO;
import ca.cal.tp2.service.dto.PreposeDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PreposeService {


    private final UtilisateurRepository repositoryUtilisateur;
    private final DocumentRepository repositoryDocument;
    private final EmpruntDetailRepository repositoryEmpruntDetail;

    public PreposeService( UtilisateurRepository uRepository, DocumentRepository dRepository, EmpruntDetailRepository eRepository) {
        this.repositoryUtilisateur = uRepository;
        this.repositoryDocument = dRepository;
        this.repositoryEmpruntDetail = eRepository;
    }


    // ------------------------ section Utilisateur ----------------------


    public void createPrepose(Utilisateur perpo) throws DataBaseException {
        repositoryUtilisateur.save(perpo);
    }

    public PreposeDTO getPreposeById(int id) throws DataBaseException {
        Utilisateur utilisateur = repositoryUtilisateur.getUtilisateurById(id);
        if (utilisateur instanceof Prepose) {
            return PreposeDTO.toDTO(utilisateur);
        }

        return null;
    }
    public PreposeDTO getPreposeByMail(String email) throws DataBaseException {
        Utilisateur utilisateur = repositoryUtilisateur.getUtilisateurByMail(email);
        if (utilisateur instanceof Prepose) {
            return PreposeDTO.toDTO(utilisateur);
        }
        return null;
    }

    // ------------------------ section Document ----------------------

    public void createDocument(Document doc) {
        repositoryDocument.save(doc);
    }


    public List<DocumentDTO> getDocumentsByTitle(String title) throws DataBaseException {
        List<Document> documents = repositoryDocument.getDocumentByTitle(title);

        return documents.stream()
                .map(document -> {
                            try {

                                String isEmprunte = repositoryEmpruntDetail.verifierDisponibilite(document.getId());
                                DocumentDTO docDTO = DocumentDTO.toDTO(document,isEmprunte);

                                return docDTO;
                            } catch (DataBaseException e) {
                                System.err.println("Erreur lors de la récupération de la disponibilité du document avec ID: " + document.getId());

                                DocumentDTO docDTO = DocumentDTO.toDTO(document,"indisponible");
                                return docDTO;
                            }
                })
                .collect(Collectors.toList());
    }



    public  List<DocumentDTO> getDocumentByAuteur(String auteur)throws DataBaseException  {
        List<Document> documents = repositoryDocument.getDocumentByAuthor(auteur);

        return documents.stream()
                .map(document -> {
                    try {

                        String isEmprunte = repositoryEmpruntDetail.verifierDisponibilite(document.getId());
                        DocumentDTO docDTO = DocumentDTO.toDTO(document,isEmprunte);

                        return docDTO;
                    } catch (DataBaseException e) {
                        System.err.println("Erreur lors de la récupération de la disponibilité du document avec auteur: " + document.getAuteur());

                        DocumentDTO docDTO = DocumentDTO.toDTO(document,"indisponible");
                        return docDTO;
                    }
                })
                .collect(Collectors.toList());
    }


}
