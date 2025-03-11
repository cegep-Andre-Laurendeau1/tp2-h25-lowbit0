package ca.cal.tp2.repo;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Document;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class EmpruntDetailRepositoryJPA implements EmpruntDetailRepository {

    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("tp2-pu");

    @Override
    public boolean isDocumentEmprunte(Document document) throws DataBaseException {

        try (EntityManager entityManager =  entityManagerFactory.createEntityManager()){
            // Query to check if the document is currently borrowed
            String query = "SELECT COUNT(d) FROM EmpruntDetail d " +
                    "WHERE d.document = :document " +
                    "AND d.dateRetourActuelle IS NULL " +
                    "AND d.dateRetourPrevue >= :currentDate";

            Long count = entityManager.createQuery(query, Long.class)
                    .setParameter("document", document)
                    .setParameter("currentDate", LocalDate.now())
                    .getSingleResult();

            // If count > 0, the document is currently borrowed
            return count > 0;
        }
        catch (Exception e) {
            throw new DataBaseException(e);
        }
    }
}
