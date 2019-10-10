package ap.repo;

import java.util.HashMap;
import java.util.Map;

import ap.model.Animal;
import ap.util.IdUtil;

public abstract class AbstractRepository implements Repository {

  private IdUtil idUtil;

  private Map<Integer, Animal> storage;

  public AbstractRepository() {
    this(new IdUtil());
  }

  public AbstractRepository(IdUtil idUtil) {
    this.idUtil = idUtil;
    storage = new HashMap<>();
  }

  @Override
  public Animal get(Integer id) {
    return storage.get(id);
  }

  @Override
  public Animal saveOrUpdate(Animal animal) {
    Integer id = animal.getId();
    if (id == null) {
      id = idUtil.getFirstAvailableId();
      animal.setId(id);
    }
    storage.put(id, animal);
    return animal;
  }

  @Override
  public void remove(Animal animal) {
    remove(animal.getId());
  }

  @Override
  public void remove(Integer id) {
    idUtil.releaseId(id);
    storage.remove(id);
  }
}
