package ap.repo;

import ap.model.Dog;

public class DogRepository extends AbstractRepository {

  @Override
  public Dog get(Integer id) {
    return (Dog) super.get(id);
  }
}
