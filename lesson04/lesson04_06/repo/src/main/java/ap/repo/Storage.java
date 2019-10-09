package ap.repo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import ap.model.Animal;

public abstract class Storage {

  protected static final int NON_ID = -1;

  private Map<Integer, Animal> storage = new HashMap<>();
  private Stack<Integer> ids = new Stack<>();

  public void addAnimal(Animal animal) {
    storage.put(animal.getId(), animal);
  }

  public Animal getAnimal(Integer id) {
    return storage.get(id);
  }

  public Animal getAnimal(String name) {
    if (name == null || name == "") {
      return null;
    }

    return storage.values()
        .stream()
        .filter(a -> name.equals(a.getName()))
        .findAny()
        .orElse(null);
  }

  public Integer getFirstAvailableId() {
    if (!ids.empty()) {
      return ids.pop();
    }

    return NON_ID;
  }

  public void removeAnimal(Integer id) {
    ids.push(id);
    storage.remove(id);
  }
}
