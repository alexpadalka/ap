package ap.repo.impl;

import ap.model.pet.Dog;
import ap.repo.AbstractRepository;

public class DogRepository extends AbstractRepository {

  @Override
  public Dog get(Integer id) {
    return (Dog) super.get(id);
  }
}
