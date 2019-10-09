package ap.repo.impl;

import ap.model.Animal;
import ap.model.Dog;
import ap.repo.Storage;

public class DogStorage extends Storage {

  private static Integer counter = 0;

  public static DogStorage getInstance() {
    return DogStorage.LazyHolder.INSTANCE;
  }

  private static class LazyHolder{
    private static final DogStorage INSTANCE = new DogStorage();
  }

  @Override
  public Dog getAnimal(Integer id) {
    return (Dog) super.getAnimal(id);
  }

  @Override
  public Dog getAnimal(String name) {
    return (Dog) super.getAnimal(name);
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
