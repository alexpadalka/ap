package ap.lesson02_jvm.task04;

public abstract class Pet implements Animal {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
