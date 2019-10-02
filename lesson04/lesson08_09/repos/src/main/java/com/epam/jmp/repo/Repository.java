package com.epam.jmp.repo;

import com.epam.jmp.model.Animal;

public interface Repository {
  Animal get(Integer id);
  void saveOrUpdate(Animal animal);
  void remove(Animal animal);
  void remove(Integer id);
}
