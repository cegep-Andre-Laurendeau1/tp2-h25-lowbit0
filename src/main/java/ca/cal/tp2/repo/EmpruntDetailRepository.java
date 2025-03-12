package ca.cal.tp2.repo;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Document;

public interface EmpruntDetailRepository {
    public boolean isDocumentEmprunte(Document document) throws DataBaseException;

    public String verifierDisponibilite(int documentId) throws DataBaseException;
}
