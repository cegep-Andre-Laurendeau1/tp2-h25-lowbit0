package ca.cal.tp2.service;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Prepose;
import ca.cal.tp2.modele.Utilisateur;
import ca.cal.tp2.repo.DocumentRepository;
import ca.cal.tp2.repo.UtilisateurRepository;
import ca.cal.tp2.service.dto.PreposeDTO;

import java.util.List;

public class PreposeService {


    private final UtilisateurRepository repositoryUtilisateur;
    private final DocumentRepository repositoryDocument;

    public PreposeService( UtilisateurRepository uRepository, DocumentRepository dRepository){
        this.repositoryUtilisateur = uRepository;
        this.repositoryDocument = dRepository;}

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


    public void createDocument(Document doc) {
        repositoryDocument.save(doc);
    }

    public Document getDocumentById(int id) {
        return null;
    }

    public Document getAllDocument()throws DataBaseException  {return null;}

    public List<Document> getDocumentByTitle(String title)throws DataBaseException  {
        return repositoryDocument.getDocumentByTitle(title);}

    public  List<Document> getDocumentByType(String type)throws DataBaseException  {
        return repositoryDocument.getDocumentByType(type);}
}
