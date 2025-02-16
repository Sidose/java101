package lessons.hw5.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.Optional;
import lessons.hw5.model.Role;
import lessons.hw5.repository.RoleRepository;
import lessons.hw5.util.JpaUtil;

/**
 * Manages a role creation, update, search.
 */
public class RoleRepositoryImpl implements RoleRepository {
  private final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

  @Override
  public Role create(Role role) {
    EntityTransaction transaction = null;
    try (EntityManager entityManager = emf.createEntityManager()) {
      transaction = entityManager.getTransaction();
      transaction.begin();
      entityManager.persist(role);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
    }
    return role;
  }

  @Override
  public Optional<Role> findById(Long id) {
    try (EntityManager entityManager = emf.createEntityManager()) {
      return Optional.ofNullable(entityManager.find(Role.class, id));
    }
  }
}
