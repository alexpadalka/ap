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
import ap.model.pet.Cat;
import ap.repo.impl.CatRepository;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class CatServiceTest {

  @Mock
  private CatRepository repository;
  private CatService service;

  private Cat mockedCat;

  @BeforeEach
  public void init() {
    service = new CatService(repository);
    mockedCat = new Cat();
    mockedCat.setName("Cat");
    mockedCat.setId(1);
  }

  @Test
  public void testCreate() {
    when(repository.saveOrUpdate(any(Cat.class))).thenReturn(mockedCat);

    Animal animal = service.create("Cat");

    assertEquals(mockedCat.getId(), animal.getId());
    assertEquals(mockedCat.getName(), animal.getName());
  }

  @Test
  public void testGet() {
    when(repository.get(anyInt())).thenReturn(mockedCat);

    Animal animal = service.get(1);

    assertEquals(mockedCat.getId(), animal.getId());
    assertEquals(mockedCat.getName(), animal.getName());
  }

  @Test
  public void testUpdate() {
    when(repository.get(anyInt())).thenReturn(mockedCat);


    Animal animal = service.get(1);
    animal.setName("Tac");
    service.update(animal);

    mockedCat.setName("Tac");
    animal = service.get(1);

    assertEquals(mockedCat.getId(), animal.getId());
    assertEquals(mockedCat.getName(), animal.getName());
  }

  @Test
  public void testRemoveByAnimal() {
    when(repository.get(anyInt())).thenReturn(mockedCat);


    Animal animal = service.get(1);
    assertNotEquals(null, animal);
    service.delete(animal);

    when(repository.get(anyInt())).thenReturn(null);
    animal = service.get(1);

    assertEquals(null, animal);
  }

  @Test
  public void testRemoveById() {
    when(repository.get(anyInt())).thenReturn(mockedCat);


    Animal animal = service.get(1);
    assertNotEquals(null, animal);
    service.delete(1);

    when(repository.get(anyInt())).thenReturn(null);
    animal = service.get(1);

    assertEquals(null, animal);
  }

  @Test
  public void testNewService() {
    assertNotEquals(null, new CatService("cat"));
  }
}
