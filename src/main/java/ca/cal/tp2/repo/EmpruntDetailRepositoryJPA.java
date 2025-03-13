package ca.cal.tp2.repo;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Document;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;

public class EmpruntDetailRepositoryJPA implements EmpruntDetailRepository {

    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("tp2-pu");

    @Override
    public boolean isDocumentEmprunte(Document document) throws DataBaseException {

        try (EntityManager entityManager =  entityManagerFactory.createEntityManager()){
            String query = "SELECT COUNT(d) FROM EmpruntDetail d " +
                    "WHERE d.document = :document " +
                    "AND d.dateRetourActuelle IS NULL " +
                    "AND d.dateRetourPrevue >= :currentDate";

            Long count = entityManager.createQuery(query, Long.class)
                    .setParameter("document", document)
                    .setParameter("currentDate", LocalDate.now())
                    .getSingleResult();

            return count > 0;
        }
        catch (Exception e) {
            throw new DataBaseException(e);
        }
    }

    @Override
    public String verifierDisponibilite(int documentId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            String query = "SELECT COUNT(ed) FROM EmpruntDetail ed " +
                    "WHERE ed.document.id = :document " +
                    "AND (ed.dateRetourPrevue >= :today OR ed.dateRetourActuelle IS NULL)";
            TypedQuery<Long> typedQuery = entityManager.createQuery(query, Long.class);
            typedQuery.setParameter("document", documentId);
            typedQuery.setParameter("today", LocalDate.now());
            Long count = typedQuery.getSingleResult();
            return (count == 0) ? "Disponible" : "Indisponible";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur lors de la vérification";
        }
    }



}
