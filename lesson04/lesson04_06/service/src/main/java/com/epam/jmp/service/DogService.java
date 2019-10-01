package com.epam.jmp.service;

import com.epam.jmp.model.Dog;

public interface DogService {

  Dog get(String name);
  Dog get(Integer id);
  void saveOrUpdate(Dog cat);
  void delete(Dog cat);

}
