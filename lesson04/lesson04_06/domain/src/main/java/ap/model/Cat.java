package ap.model;

public class Cat extends Pet {

  @Override
  public void play() {
    System.out.println("Cat '" + getName() + "' is playing");
  }

  @Override
  public void voice() {
    System.out.println("Cat '" + getName() + "' say 'Meow'");
  }

}
