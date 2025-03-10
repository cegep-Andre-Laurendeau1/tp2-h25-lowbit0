package ca.cal.tp2.repo;

import ca.cal.tp2.modele.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UtilisateurRepositoryJPA implements UtilisateurRepository {
    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("tp2-pu");

    @Override
    public void save(Utilisateur utilisateur) {
        try( EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(utilisateur);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Utilisateur getUtilisateurById(int id) {
        try( EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.find(Utilisateur.class, id);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
