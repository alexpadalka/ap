package ap.repo.impl;

import ap.model.Animal;
import ap.model.Cat;
import ap.repo.Storage;

public class CatStorage extends Storage {

  private static Integer counter = 0;

  public static CatStorage getInstance() {
    return CatStorage.LazyHolder.INSTANCE;
  }

  private static class LazyHolder{
    private static final CatStorage INSTANCE = new CatStorage();
  }

  @Override
  public Cat getAnimal(Integer id) {
    return (Cat) super.getAnimal(id);
  }

  @Override
  public Cat getAnimal(String name) {
    return (Cat) super.getAnimal(name);
  }

  @Override
  public Integer getFirstAvailableId() {
    Integer id = super.getFirstAvailableId();

    if (id != NON_ID) {
      return id;
    }

    counter++;
    id = counter;

    return id;
  }

  public void removeAnimal(Animal animal) {
    super.removeAnimal(animal.getId());
  }
}
