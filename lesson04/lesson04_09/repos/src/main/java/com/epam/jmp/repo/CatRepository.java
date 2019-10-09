package com.epam.jmp.repo;

import com.epam.jmp.model.Cat;

public class CatRepository extends AbstractRepository {

  @Override
  public Cat get(Integer id) {
    return (Cat) super.get(id);
  }
}
