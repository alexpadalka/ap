package ap.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import ap.service.Service;
import ap.service.impl.CatService;
import ap.service.impl.DogService;

public class ServiceSupplier {

  private static final Map<String, Supplier<Service>> SERVICE_SUPPLIER;

  static {
    final Map<String, Supplier<Service>> services = new HashMap<>();
    services.put("CAT", CatService::new);
    services.put("DOG", DogService::new);

    SERVICE_SUPPLIER = Collections.unmodifiableMap(services);
  }

  public Service supply(String animalType) {
    Supplier<Service> service = SERVICE_SUPPLIER.get(animalType.toUpperCase());

    if (service == null) {
      throw new IllegalArgumentException("Invalid service type: " + animalType);
    }
    return service.get();
  }
}
