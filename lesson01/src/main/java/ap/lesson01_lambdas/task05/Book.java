package ap.lesson01_lambdas.task05;

import java.util.ArrayList;
import java.util.List;

public class Book {

  private String title;
  private int numPages;
  private List<Author> authors;

  public Book() {
    authors = new ArrayList<>();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getNumPages() {
    return numPages;
  }

  public void setNumPages(int numPages) {
    this.numPages = numPages;
  }

  public List<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(List<Author> authors) {
    this.authors = authors;
  }

  @Override
  public String toString() {
    return "\n\tBook{"
        + "title='"
        + title
        + '\''
        + ", numPages="
        + numPages
        + ", authors count= "
        + authors.size()
        + "}";
  }
}

