package ap.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ap.model.Animal;
import ap.model.pet.Dog;
import ap.repo.impl.DogRepository;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class DogServiceTest {

  @Mock
  private DogRepository repository;
  private DogService service;

  private Dog mockedDog;

  @BeforeEach
  public void init() {
    service = new DogService(repository);
    mockedDog = new Dog();
    mockedDog.setName("Dog");
    mockedDog.setId(1);
  }

  @Test
  public void testCreate() {
    when(repository.saveOrUpdate(any(Dog.class))).thenReturn(mockedDog);

    Animal animal = service.create("Dog");

    assertEquals(mockedDog.getId(), animal.getId());
    assertEquals(mockedDog.getName(), animal.getName());
  }

  @Test
  public void testGet() {
    when(repository.get(anyInt())).thenReturn(mockedDog);

    Animal animal = service.get(1);

    assertEquals(mockedDog.getId(), animal.getId());
    assertEquals(mockedDog.getName(), animal.getName());
  }

  @Test
  public void testUpdate() {
    when(repository.get(anyInt())).thenReturn(mockedDog);


    Animal animal = service.get(1);
    animal.setName("Tac");
    service.update(animal);

    mockedDog.setName("Tac");
    animal = service.get(1);

    assertEquals(mockedDog.getId(), animal.getId());
    assertEquals(mockedDog.getName(), animal.getName());
  }

  @Test
  public void testRemoveByAnimal() {
    when(repository.get(anyInt())).thenReturn(mockedDog);


    Animal animal = service.get(1);
    assertNotEquals(null, animal);
    service.delete(animal);

    when(repository.get(anyInt())).thenReturn(null);
    animal = service.get(1);

    assertEquals(null, animal);
  }

  @Test
  public void testRemoveById() {
    when(repository.get(anyInt())).thenReturn(mockedDog);


    Animal animal = service.get(1);
    assertNotEquals(null, animal);
    service.delete(1);

    when(repository.get(anyInt())).thenReturn(null);
    animal = service.get(1);

    assertEquals(null, animal);
  }

  @Test
  public void testNewService() {
    assertNotEquals(null, new DogService("dog"));
  }
}
