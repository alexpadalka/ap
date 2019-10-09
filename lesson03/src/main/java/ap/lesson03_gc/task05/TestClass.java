package ap.lesson03_gc.task05;

public class TestClass {

  private String string;

  public TestClass() {
    this("Test string");
//    this("Test string 111");
  }

  public TestClass(String string) {
    this.string = string;
  }

  public void print() {
    System.out.println("This is print method with " + string);
  }

//  public void printNew(String param) {
//    print();
//    System.out.println("This is new print method with " + param);
//  }
}
