package ca.cal.tp2.repo;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.exception.DocumentPasDisponibleException;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDetail;
import ca.cal.tp2.modele.Utilisateur;
import ca.cal.tp2.service.dto.DocumentDTO;
import ca.cal.tp2.service.dto.DocumentEmprunteDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class EmpruntRepositoryJPA implements EmpruntRepository{
    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("tp2-pu");

    private final EmpruntDetailRepository empruntDetailRepository;

    public EmpruntRepositoryJPA(EmpruntDetailRepository empruntDetailRepository) {
        this.empruntDetailRepository = empruntDetailRepository;
    }


    @Override
    public void saveEmprunt(Emprunt emprunt) throws DataBaseException,DocumentPasDisponibleException {

        try( EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            entityManager.getTransaction().begin();

            for (EmpruntDetail detail : emprunt.getEmpruntDetail()) {
                Document document = detail.getDocument();
              if (empruntDetailRepository.isDocumentEmprunte(document)){
                    throw new DocumentPasDisponibleException("Le document " + document.getTitre() + " est déjà emprunté");
              }
            }

            emprunt.setEmprunteur(entityManager.merge(emprunt.getEmprunteur()));
            for (EmpruntDetail detail : emprunt.getEmpruntDetail()) {
                detail.setDocument(entityManager.merge(detail.getDocument()));
            }
            entityManager.persist(emprunt);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DataBaseException(e);
        }
    }

    @Override
    public List<DocumentEmprunteDTO> getDocumentEmprunte(Utilisateur utilisateur) throws DataBaseException {
        try( EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            String query = "SELECT d.titre, e.dateEmprunt, ed.dateRetourPrevue FROM Document d " +
                    "JOIN EmpruntDetail ed ON d.id = ed.document.id " +
                    "JOIN Emprunt e ON ed.emprunt.id = e.id " +
                    "WHERE e.emprunteur.email = :email " +
                    "AND ed.dateRetourActuelle IS NULL";

            TypedQuery<DocumentEmprunteDTO> typedQuery = entityManager.createQuery(query, DocumentEmprunteDTO.class);
            typedQuery.setParameter("email", utilisateur.getEmail());


            return typedQuery.getResultList();
        }
        catch (Exception e) {
            throw new DataBaseException(e);
        }

    }
}
