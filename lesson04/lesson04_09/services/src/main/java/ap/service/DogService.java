package ap.service;

import ap.model.Dog;
import ap.repo.DogRepository;

public class DogService extends AbstractService {

  public DogService() {
    super(new DogRepository());
  }

  @Override
  public Dog get(Integer id) {
    return (Dog) super.get(id);
  }

  @Override
  public Dog create() {
    Dog dog = new Dog();
    repo.saveOrUpdate(dog);
    return dog;
  }
}
