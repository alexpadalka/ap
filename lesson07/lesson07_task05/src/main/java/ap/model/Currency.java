package ap.model;

public class Currency {

  private String abbreviation;
  private Integer code;
  private String name;

  public Currency(String abbreviation, Integer code, String name) {
    this.abbreviation = abbreviation;
    this.code = code;
    this.name = name;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public Integer getCode() {
    return code;
  }

  public String getName() {
    return name;
  }
}
