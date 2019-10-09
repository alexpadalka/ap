package ap.model;

public abstract class Pet implements Animal {

  private String name;
  private Integer id;

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String play() {
    return getName() + " is playing.";
  }
}
