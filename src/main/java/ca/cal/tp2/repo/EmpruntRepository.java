package ca.cal.tp2.repo;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Utilisateur;
import ca.cal.tp2.service.dto.DocumentDTO;
import ca.cal.tp2.service.dto.DocumentEmprunteDTO;

import java.util.List;

public interface EmpruntRepository {
    public void saveEmprunt(Emprunt emprunt) throws DataBaseException;

    public List<DocumentEmprunteDTO> getDocumentEmprunte(Utilisateur utilisateur) throws DataBaseException;

}
