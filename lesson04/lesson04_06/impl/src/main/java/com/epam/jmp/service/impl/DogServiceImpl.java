package com.epam.jmp.service.impl;

import com.epam.jmp.model.Dog;
import com.epam.jmp.repo.impl.DogStorage;
import com.epam.jmp.service.DogService;

public class DogServiceImpl implements DogService {

  public static DogService getInstance() {
    return DogServiceImpl.LazyHolder.INSTANCE;
  }

  private static class LazyHolder{
    private static final DogService INSTANCE = new DogServiceImpl();
  }

  private DogStorage storage;

  public DogServiceImpl() {
    storage = DogStorage.getInstance();
  }

  @Override
  public Dog get(String name) {
    if (name == null || name == "") {
      return null;
    }

    Dog dog = storage.getAnimal(name);

    if (dog != null) {
      return dog;
    }

    dog = new Dog();
    dog.setName(name);
    dog.setId(storage.getFirstAvailableId());

    saveOrUpdate(dog);

    return dog;
  }

  @java.lang.Override
  public Dog get(Integer id) {
    return storage.getAnimal(id);
  }

  @java.lang.Override
  public void saveOrUpdate(Dog dog) {
    storage.addAnimal(dog);
  }

  @java.lang.Override
  public void delete(Dog dog) {
    storage.removeAnimal(dog);
  }
}
