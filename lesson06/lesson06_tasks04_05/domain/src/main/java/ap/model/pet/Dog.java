package ap.model.pet;

import ap.model.Pet;

public class Dog extends Pet {

  @Override
  public String play() {
    return "Dog '" + getName() + "' is playing";
  }

  @Override
  public String voice() {
    return "Dog '" + getName() + "' say 'R-r-r-r'";
  }
}
