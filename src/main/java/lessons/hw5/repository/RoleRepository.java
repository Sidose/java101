package lessons.hw5.repository;

import lessons.hw5.model.Role;

import java.util.Optional;

public interface RoleRepository {
  /**
   * Creates role.
   *
   * @param role Role object.
   * @return Created role object.
   */
  Role create(Role role);

  /**
   * Finds role by ID.
   *
   * @param id Role ID.
   * @return Role object.
   */
  Optional<Role> findById(Long id);
}
