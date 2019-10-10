package ap.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ap.service.Service;
import ap.service.impl.CatService;
import ap.service.impl.DogService;

class ServiceSupplierTest {
  
  private ServiceSupplier supplier;

  @BeforeEach
  public void init() {
    supplier = new ServiceSupplier();
  }

  @Test
  public void testSupply() {
    Service service = supplier.supply("Cat");
    assertTrue(CatService.class.isInstance(service));
    assertFalse(DogService.class.isInstance(service));

    service = supplier.supply("cat");
    assertTrue(CatService.class.isInstance(service));
    assertFalse(DogService.class.isInstance(service));

    service = supplier.supply("DOG");
    assertFalse(CatService.class.isInstance(service));
    assertTrue(DogService.class.isInstance(service));
  }

  @Test
  public void testSupplyGenerateException() {
    assertThrows(IllegalArgumentException.class, () -> supplier.supply("Bird"));
  }
}