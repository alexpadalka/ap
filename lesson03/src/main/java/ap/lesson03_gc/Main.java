package ap.lesson03_gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ap.lesson03_gc.task05.Helper;

public class Main {

  public static void main(String[] args) {
//    executeTask01();
//    executeTask02();
//    executeTask03();
//    executeTask04();
//    executeTask05();
  }

  private static void executeTask01() {
    // -Xmx256M
    // G1 GC -XX:+UseG1GC
    // CMS GC -XX:+UseConcMarkSweepGC
    // Serial GC -XX:+UseSerialGC
    // Parallel GC -XX:+UseParallelGC or -XX:+UseParNewGC
    // -XX:MinHeapFreeRatio=95 -XX:MaxHeapFreeRatio=95 ??
  }

  private static void executeTask02() {
    List<Object> list = new ArrayList<>();
    while(true) {
      list.add(new Object());
    }
  }

  private static void executeTask03() {
    List<Object> list = new ArrayList<>();
    while(true) {
      list.add(new Object());
    }
  }

  private static void executeTask04() {
    List<Object> list = new ArrayList<>();
    while(true) {
      list.add(new Object());
    }
  }

  private static void executeTask05() {
    int select = 0;
    do {
      System.out.println("Please select menu item");
      System.out.println("1 - create new instance, 2 - reload class, 3 - reload class with new method, 4 - exit");
      Scanner scanner = new Scanner(System.in);
      select = scanner.nextInt();

      if (select == 4) {
        break;
      }

      if (select < 1 || select > 4) {
        System.out.println("invalid menu item, please try again");
        continue;
      }

      switch (select) {
        case 1:
          run0501();
          break;
        case 2:
          run0502();
          break;
        case 3:
          run0503(scanner);
          break;
      }

    } while (select != 4);
  }

  private static Helper helper = new Helper();

  private static void run0501() {
    helper.run0501();
  }

  private static void run0502() {
    helper.run0502();
  }

  private static void run0503(Scanner scanner) {
    System.out.println("Please type method name");
    String methodName = scanner.next();
    System.out.println("Please type method param");
    String param = scanner.next();
    helper.run0503(methodName, param);
  }
}
