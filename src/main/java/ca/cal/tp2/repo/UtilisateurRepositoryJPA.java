package ca.cal.tp2.repo;

import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class UtilisateurRepositoryJPA implements UtilisateurRepository {
    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("tp2-pu");

    @Override
    public void save(Utilisateur utilisateur) throws DataBaseException {
        try( EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(utilisateur);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DataBaseException(e);
        }
    }

    @Override
    public Utilisateur getUtilisateurById(int id) throws DataBaseException {
        try( EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.find(Utilisateur.class, id);
        }
        catch (Exception e) {
            throw new DataBaseException(e);
        }
    }


    @Override
    public Utilisateur getUtilisateurByMail(String email) throws DataBaseException {
        try( EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Utilisateur> query = entityManager.createQuery(
                    "SELECT u FROM Utilisateur u WHERE u.email = :email", Utilisateur.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        }
        catch (Exception e) {
            throw new DataBaseException(e);
        }

    }


}
