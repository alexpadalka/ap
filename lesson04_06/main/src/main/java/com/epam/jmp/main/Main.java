package com.epam.jmp.main;

import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.model.Animal;
import com.epam.jmp.service.CatService;
import com.epam.jmp.service.DogService;
import com.epam.jmp.service.impl.CatServiceImpl;
import com.epam.jmp.service.impl.DogServiceImpl;

public class Main {

  public static void main(String[] args) {
    System.out.println("Print from main library");

    CatService catService = CatServiceImpl.getInstance();
    DogService dogService = DogServiceImpl.getInstance();

    List<Animal> animals = new ArrayList<>();

    animals.add(catService.get("Vas'ka"));
    animals.add(dogService.get("Max"));

    animals.forEach(Animal::play);
    animals.forEach(Animal::voice);
  }

}