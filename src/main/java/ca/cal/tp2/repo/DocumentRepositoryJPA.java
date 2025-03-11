package ca.cal.tp2.repo;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Document;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DocumentRepositoryJPA implements DocumentRepository {
    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("tp2-pu");

    @Override
    public void save(Document document) {
        try( EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(document);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Document> getDocumentByTitle(String title) throws DataBaseException {

        try( EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Document> query = entityManager.createQuery(
                    "SELECT d FROM Document d WHERE Lower(d.titre) LIKE :title", Document.class);
            query.setParameter("title", "%" + title.toLowerCase() + "%");
            return query.getResultList();
        }
        catch (Exception e) {
            throw new DataBaseException(e);
        }
    }

    @Override
    public List<Document> getDocumentByAuthor(String author) {
        return null;
    }

    @Override
    public List<Document> getDocumentByArtist(String artist) {
        return null;
    }

    @Override
    public List<Document> getDocumentByType(String type) {
        return List.of();
    }
}
