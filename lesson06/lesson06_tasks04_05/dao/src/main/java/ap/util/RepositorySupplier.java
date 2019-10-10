package ap.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import ap.repo.Repository;
import ap.repo.impl.CatRepository;
import ap.repo.impl.DogRepository;

public class RepositorySupplier {

  private static final Map<String, Supplier<Repository>> REPOSITORY_SUPPLIER;

  static {
    final Map<String, Supplier<Repository>> repositories = new HashMap<>();
    repositories.put("CAT", CatRepository::new);
    repositories.put("DOG", DogRepository::new);

    REPOSITORY_SUPPLIER = Collections.unmodifiableMap(repositories);
  }

  public Repository supply(String animalType) {
    Supplier<Repository> repository = REPOSITORY_SUPPLIER.get(animalType.toUpperCase());

    if (repository == null) {
      throw new IllegalArgumentException("Invalid repository type: " + animalType);
    }
    return repository.get();
  }
}
