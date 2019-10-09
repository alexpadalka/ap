package ap.service;

import ap.model.Cat;
import ap.repo.CatRepository;

public class CatService extends AbstractService {

  public CatService() {
    super(new CatRepository());
  }

  @Override
  public Cat get(Integer id) {
    return (Cat) super.get(id);
  }

  @Override
  public Cat create() {
    Cat dog = new Cat();
    repo.saveOrUpdate(dog);
    return dog;
  }
}
