package ca.cal.tp2.repo;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpruntRepositoryJPA implements EmpruntRepository{
    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("tp2-pu");



    @Override
    public void saveEmprunt(Emprunt emprunt) throws DataBaseException {

        try( EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            entityManager.getTransaction().begin();

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
}
