package ca.cal.tp2.service;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Prepose;
import ca.cal.tp2.modele.Utilisateur;
import ca.cal.tp2.repo.DocumentRepository;
import ca.cal.tp2.repo.UtilisateurRepository;
import ca.cal.tp2.service.dto.DocumentDTO;
import ca.cal.tp2.service.dto.PreposeDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PreposeService {


    private final UtilisateurRepository repositoryUtilisateur;
    private final DocumentRepository repositoryDocument;

    public PreposeService( UtilisateurRepository uRepository, DocumentRepository dRepository){
        this.repositoryUtilisateur = uRepository;
        this.repositoryDocument = dRepository;}


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
                .map(DocumentDTO::toDTO)
                .collect(Collectors.toList());
    }



    public  List<Document> getDocumentByType(String type)throws DataBaseException  {
        return repositoryDocument.getDocumentByType(type);}
}
