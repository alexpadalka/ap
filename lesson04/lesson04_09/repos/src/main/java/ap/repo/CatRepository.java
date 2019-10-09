package ap.repo;

import ap.model.Cat;

public class CatRepository extends AbstractRepository {

  @Override
  public Cat get(Integer id) {
    return (Cat) super.get(id);
  }
}
