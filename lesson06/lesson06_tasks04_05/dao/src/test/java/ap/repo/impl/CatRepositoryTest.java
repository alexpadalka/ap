package ap.repo.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ap.model.Animal;
import ap.model.pet.Cat;
import ap.repo.Repository;

class CatRepositoryTest {

  private Repository repository;

  @BeforeEach
  public void init() {
    repository = new CatRepository();
  }

  @Test
  public void testGet() {
    assertEquals(null, repository.get(1));
  }

  @Test
  public void testSaveOrUpdate() {
    assertEquals(null, repository.get(1));

    Animal animal = new Cat();
    animal.setId(1);
    animal.setName("Cat");
    repository.saveOrUpdate(animal);

    assertEquals(animal, repository.get(1));
  }

  @Test
  public void testRemove() {
    assertEquals(null, repository.get(1));

    Animal animal = new Cat();
    animal.setId(1);
    animal.setName("Cat");
    repository.saveOrUpdate(animal);

    assertEquals(animal, repository.get(1));

    repository.remove(animal);
    assertEquals(null, repository.get(1));
  }

  @Test
  public void testSaveOrUpdateNew() {
    assertEquals(null, repository.get(1));

    Animal animal = new Cat();
    animal.setName("Cat");
    repository.saveOrUpdate(animal);

    assertEquals(animal, repository.get(1));

    repository.remove(animal);
    assertEquals(null, repository.get(1));

    animal = new Cat();
    animal.setName("Cat");
    repository.saveOrUpdate(animal);

    assertEquals(animal, repository.get(1));
  }
}