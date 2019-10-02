package com.epam.jmp.service;

import com.epam.jmp.model.Cat;

public interface CatService {

  Cat get(String name);
  Cat get(Integer id);
  void saveOrUpdate(Cat cat);
  void delete(Cat cat);

}
