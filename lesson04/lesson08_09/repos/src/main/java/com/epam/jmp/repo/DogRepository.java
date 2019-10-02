package com.epam.jmp.repo;

import com.epam.jmp.model.Dog;

public class DogRepository extends AbstractRepository {

  @Override
  public Dog get(Integer id) {
    return (Dog) super.get(id);
  }
}
