package ap.lesson01_lambdas.task02;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
  private int age;
  private String name;
  private String address;

  public Person() {
    this(0, "");
  }

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append("Person{")
        .append(age)
        .append(", name='")
        .append(name)
        .append(", address='")
        .append(address)
        .append("'}")
        .toString();
  }

  public static List<Person> comparing(List<Person> people, Comparator<Person> comparator) {
    return people
        .stream()
        .sorted(comparator::compare)
        .collect(Collectors.toList());
  }

}
