package ca.cal.tp2.repo;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Utilisateur;

import java.util.List;

// a revoir tous les execptions

public interface DocumentRepository {
    public void save(Document document);

    public List<Document> getDocumentByTitle(String title) throws DataBaseException;

    public List<Document> getDocumentByAuthor(String author) throws DataBaseException;

    public List<Document> getDocumentByArtist(String artist);

    public List<Document> getDocumentByType(String type);



}
