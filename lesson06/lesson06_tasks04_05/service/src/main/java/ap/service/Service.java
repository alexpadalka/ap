package ap.service;

import ap.model.Animal;

public interface Service {
  Animal create(String name);
  Animal get(Integer id);
  void update(Animal animal);
  void delete(Animal animal);
  void delete(Integer id);
}
