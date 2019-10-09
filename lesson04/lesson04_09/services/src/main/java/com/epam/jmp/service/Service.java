package com.epam.jmp.service;

import com.epam.jmp.model.Animal;

public interface Service {
  Animal get(Integer id);
  Animal create();
  void save(Animal animal);
  void delete(Animal animal);
}
