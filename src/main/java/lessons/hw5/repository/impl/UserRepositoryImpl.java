package lessons.hw5.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.Optional;
import lessons.hw5.model.User;
import lessons.hw5.repository.UserRepository;
import lessons.hw5.util.JpaUtil;

/**
 * Manages a user creation, update, search.
 */
public class UserRepositoryImpl implements UserRepository {
  private final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

  @Override
  public User create(User user) {
    EntityTransaction transaction = null;
    try (EntityManager entityManager = emf.createEntityManager()) {
      transaction = entityManager.getTransaction();
      transaction.begin();
      entityManager.persist(user);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
    }
    return user;
  }

  @Override
  public Optional<User> findById(Long id) {
    try (EntityManager entityManager = emf.createEntityManager()) {
      return Optional.ofNullable(entityManager.find(User.class, id));
    }
  }

  @Override
  public User update(User user) {
    EntityTransaction transaction = null;
    try (EntityManager entityManager = emf.createEntityManager()) {
      transaction = entityManager.getTransaction();
      transaction.begin();
      entityManager.merge(user);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
    }
    return user;
  }
}
