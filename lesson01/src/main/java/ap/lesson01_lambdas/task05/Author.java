package ap.lesson01_lambdas.task05;

import java.util.ArrayList;
import java.util.List;

public class Author {

  private String name;
  private short age;
  private List<Book> books;

  public Author() {
    books = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public short getAge() {
    return age;
  }

  public void setAge(short age) {
    this.age = age;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  @Override
  public String toString() {
    return "\n\tAuthor{"
        + "name='"
        + name
        + '\''
        + ", age="
        + age
        + ", books count="
        + books.size()
        + "}";
  }
}

