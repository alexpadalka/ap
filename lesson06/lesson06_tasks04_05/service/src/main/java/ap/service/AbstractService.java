package ap.service;

import ap.model.Animal;
import ap.repo.Repository;
import ap.util.RepositorySupplier;

public abstract class AbstractService implements Service {

  protected Repository repository;

  public AbstractService(String animalType) {
    this((new RepositorySupplier()).supply(animalType));
  }

  public AbstractService(Repository repository) {
    this.repository = repository;
  }

  @Override
  public Animal get(Integer id) {
    return repository.get(id);
  }

  @Override
  public void update(Animal animal) {
    repository.saveOrUpdate(animal);
  }

  @Override
  public void delete(Animal animal) {
    repository.remove(animal);
  }

  @Override
  public void delete(Integer id) {
    repository.remove(id);
  }
}
