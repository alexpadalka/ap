package ap.service;

import ap.model.Animal;
import ap.repo.Repository;

public abstract class AbstractService implements Service {

  protected Repository repo;

  public AbstractService(Repository repo) {
    this.repo = repo;
  }

  @Override
  public Animal get(Integer id) {
    return repo.get(id);
  }

  @Override
  public abstract Animal create();

  @Override
  public void save(Animal animal) {
    repo.saveOrUpdate(animal);
  }

  @Override
  public void delete(Animal animal) {
    repo.remove(animal);
  }
}
