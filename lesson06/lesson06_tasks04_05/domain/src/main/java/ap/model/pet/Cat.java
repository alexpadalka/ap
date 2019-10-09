package ap.model.pet;

import ap.model.Pet;

public class Cat extends Pet {

  @Override
  public String play() {
   return "Cat '" + getName() + "' is playing";
  }

  @Override
  public String voice() {
    return "Cat '" + getName() + "' say 'Meow'";
  }
}
