package lessons.hw5;

import lessons.hw5.model.Role;
import lessons.hw5.model.User;
import lessons.hw5.repository.RoleRepository;
import lessons.hw5.repository.UserRepository;
import lessons.hw5.repository.impl.RoleRepositoryImpl;
import lessons.hw5.repository.impl.UserRepositoryImpl;

/**
 * Main class.
 */
public final class Main {

  /**
   * Constructor.
   */
  private Main() {
  }

  /**
   * Main method.
   *
   * @param args Arguments.
   */
  public static void main(String[] args) {
    UserRepository userRepository = new UserRepositoryImpl();

    User user = new User("mike@mail.com", "Mike");
    User userCreated = userRepository.create(user);
    System.out.println("Created user: " + userCreated);

    User userFound = userRepository.findById(userCreated.getId()).orElseThrow();
    System.out.println("\nFound user by ID: " + userFound);

    userFound.setName("\nMike updated");
    User userUpdated = userRepository.update(userFound);
    System.out.println("\nUser updated: " + userUpdated);

    Role roleAdmin = new Role("Admin");
    Role roleInstructor = new Role("Instructor");

    RoleRepository roleRepository = new RoleRepositoryImpl();

    Role roleAdminCreated = roleRepository.create(roleAdmin);
    System.out.println("\nCreated 'Admin' role: " + roleAdminCreated);

    Role roleInstructorCreated = roleRepository.create(roleInstructor);
    System.out.println("\nCreated 'Instructor' role: " + roleInstructorCreated);

    Role roleFound = roleRepository.findById(roleAdminCreated.getId()).orElseThrow();
    System.out.println("\nFound role by ID: " + roleFound);
  }
}
