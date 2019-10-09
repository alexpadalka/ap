package ap.main;

import java.util.ArrayList;
import java.util.List;

import ap.model.Animal;
import ap.service.CatService;
import ap.service.DogService;
import ap.service.impl.CatServiceImpl;
import ap.service.impl.DogServiceImpl;

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