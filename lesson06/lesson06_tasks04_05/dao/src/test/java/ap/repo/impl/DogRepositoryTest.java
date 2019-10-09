package ap.repo.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ap.model.Animal;
import ap.model.pet.Dog;
import ap.repo.Repository;

class DogRepositoryTest {

  private Repository repository;

  @BeforeEach
  public void init() {
    repository = new DogRepository();
  }

  @Test
  public void testGet() {
    assertEquals(null, repository.get(1));
  }

  @Test
  public void testSaveOrUpdate() {
    assertEquals(null, repository.get(1));

    Animal animal = new Dog();
    animal.setId(1);
    animal.setName("Dog");
    repository.saveOrUpdate(animal);

    assertEquals(animal, repository.get(1));
  }

  @Test
  public void testRemove() {
    assertEquals(null, repository.get(1));

    Animal animal = new Dog();
    animal.setId(1);
    animal.setName("Dog");
    repository.saveOrUpdate(animal);

    assertEquals(animal, repository.get(1));

    repository.remove(animal);
    assertEquals(null, repository.get(1));
  }

  @Test
  public void testSaveOrUpdateNew() {
    assertEquals(null, repository.get(1));

    Animal animal = new Dog();
    animal.setName("Dog");
    repository.saveOrUpdate(animal);

    assertEquals(animal, repository.get(1));

    repository.remove(animal);
    assertEquals(null, repository.get(1));

    animal = new Dog();
    animal.setName("Dog");
    repository.saveOrUpdate(animal);

    assertEquals(animal, repository.get(1));
  }
}