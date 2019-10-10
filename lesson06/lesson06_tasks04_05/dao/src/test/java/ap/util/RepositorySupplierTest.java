package ap.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ap.repo.Repository;
import ap.repo.impl.CatRepository;
import ap.repo.impl.DogRepository;

class RepositorySupplierTest {

  private RepositorySupplier supplier;

  @BeforeEach
  public void init() {
    supplier = new RepositorySupplier();
  }

  @Test
  public void testSupply() {
    Repository repository = supplier.supply("Cat");
    assertTrue(CatRepository.class.isInstance(repository));
    assertFalse(DogRepository.class.isInstance(repository));

    repository = supplier.supply("cat");
    assertTrue(CatRepository.class.isInstance(repository));
    assertFalse(DogRepository.class.isInstance(repository));

    repository = supplier.supply("DOG");
    assertFalse(CatRepository.class.isInstance(repository));
    assertTrue(DogRepository.class.isInstance(repository));
  }

  @Test
  public void testSupplyGenerateException() {
    assertThrows(IllegalArgumentException.class, () -> supplier.supply("Bird"));
  }
}