package ap.service.impl;

import ap.model.Animal;
import ap.model.pet.Cat;
import ap.repo.Repository;
import ap.service.AbstractService;
import ap.util.RepositorySupplier;

public class CatService extends AbstractService {

  public CatService() {
    this((new RepositorySupplier()).supply("Cat"));
  }

  public CatService(String animalType) {
    super(animalType);
  }

  public CatService(Repository repository) {
    super(repository);
  }

  @Override
  public Animal create(String name) {
    Cat cat = new Cat();
    cat.setName(name);
    return repository.saveOrUpdate(cat);
  }
}
