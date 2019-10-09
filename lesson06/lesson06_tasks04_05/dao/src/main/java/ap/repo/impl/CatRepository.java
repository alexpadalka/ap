package ap.repo.impl;

import ap.model.pet.Cat;
import ap.repo.AbstractRepository;

public class CatRepository extends AbstractRepository {

  @Override
  public Cat get(Integer id) {
    return (Cat) super.get(id);
  }
}
