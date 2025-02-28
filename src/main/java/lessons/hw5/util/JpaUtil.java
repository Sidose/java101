package lessons.hw5.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JpaUtil {
  public static final EntityManagerFactory INSTANCE = initEntityManagerFactory();

  private static EntityManagerFactory initEntityManagerFactory() {
    try {
      return Persistence.createEntityManagerFactory("manytomany");
    } catch (Exception e) {
      throw new RuntimeException("Can't create entity manager factory ", e);
    }
  }

  public static EntityManagerFactory getEntityManagerFactory() {
    return INSTANCE;
  }

}
