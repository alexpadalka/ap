package ap.service.impl;

import ap.model.Cat;
import ap.repo.impl.CatStorage;
import ap.service.CatService;

public class CatServiceImpl implements CatService {

  public static CatService getInstance() {
    return CatServiceImpl.LazyHolder.INSTANCE;
  }

  private static class LazyHolder{
    private static final CatService INSTANCE = new CatServiceImpl();
  }

  private CatStorage storage;

  public CatServiceImpl() {
    storage = CatStorage.getInstance();
  }

  @Override
  public Cat get(String name) {
    if (name == null || name == "") {
      return null;
    }

    Cat cat = storage.getAnimal(name);

    if (cat != null) {
      return cat;
    }

    cat = new Cat();
    cat.setName(name);
    cat.setId(storage.getFirstAvailableId());

    saveOrUpdate(cat);

    return cat;
  }

  @Override
  public Cat get(Integer id) {
    return storage.getAnimal(id);
  }

  @Override
  public void saveOrUpdate(Cat cat) {
    storage.addAnimal(cat);
  }

  @Override
  public void delete(Cat cat) {
    storage.removeAnimal(cat);
  }
}
