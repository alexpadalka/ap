package ap.task02;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Integer> num = Arrays.asList(12, 11, 13, 5, 6, 7, 2, 15, 8, 0, 10, 9, 4, 17);
    printArray(num, "Before:");
    printArray(ForkJoinMergeSortIntArray.sort(num), "After:");
  }

  private static void printArray(List<Integer> numbers, String text) {
    System.out.println(text);
    numbers.stream().map(num -> num + " ").forEach(System.out::print);
    System.out.println("");
  }
}
