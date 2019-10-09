package com.epam.jmp.service;

import com.epam.jmp.model.Cat;
import com.epam.jmp.repo.CatRepository;

public class CatService extends AbstractService {

  public CatService() {
    super(new CatRepository());
  }

  @Override
  public Cat get(Integer id) {
    return (Cat) super.get(id);
  }

  @Override
  public Cat create() {
    Cat dog = new Cat();
    repo.saveOrUpdate(dog);
    return dog;
  }
}
