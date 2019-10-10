package ap.service.impl;

import ap.model.Animal;
import ap.model.pet.Dog;
import ap.repo.Repository;
import ap.service.AbstractService;
import ap.util.RepositorySupplier;

public class DogService extends AbstractService {

  public DogService() {
    this((new RepositorySupplier()).supply("Dog"));
  }

  public DogService(String animalType) {
    super(animalType);
  }

  public DogService(Repository repository) {
    super(repository);
  }

  @Override
  public Animal create(String name) {
    Dog dog = new Dog();
    dog.setName(name);
    return repository.saveOrUpdate(dog);
  }
}
