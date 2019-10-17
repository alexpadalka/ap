package ap.task01;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class Main {

  private static final int END_EXCLUSIVE = 1_000_000;

  public static void main(String[] args) throws InterruptedException {
    execute01();
    execute02();
    execute03();
  }

  private static void execute01() throws InterruptedException {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Long> sumMap = new HashMap<>();

    Thread supplierThread =
        new Thread(() -> {
          synchronized (map) {
            IntStream.range(0, END_EXCLUSIVE).forEachOrdered(i -> map.put(i, i));
          }
        });

    Thread summarizeThread =
        new Thread(
            () -> {
              synchronized (map) {
                IntStream.range(0, END_EXCLUSIVE / 1_000)
                    .mapToLong(i -> map.values().stream().mapToInt(Integer::intValue).sum())
                    .forEach(
                        sum -> {
                          int size = map.entrySet().size();
                          sumMap.put(size, sum);
                        });
              }
            });

    supplierThread.start();
    summarizeThread.start();

    supplierThread.join();
    summarizeThread.join();

    System.out.println(sumMap);
  }

  private static void execute02() throws InterruptedException {
    Map<Integer, Integer> map = new ConcurrentHashMap<>();
    Map<Integer, Long> sumMap = new HashMap<>();

    Thread supplierThread =
        new Thread(
            () -> {
              synchronized (map) {
                IntStream.range(0, END_EXCLUSIVE).forEachOrdered(i -> map.put(i, i));
              }
            });

    Thread summarizeThread =
        new Thread(
            () -> {
              synchronized (map) {
                IntStream.range(0, END_EXCLUSIVE / 1_000)
                    .mapToLong(i -> map.values().stream().mapToInt(Integer::intValue).sum())
                    .forEach(
                        sum -> {
                          int size = map.entrySet().size();
                          sumMap.put(size, sum);
                        });
              }
            });

    supplierThread.start();
    summarizeThread.start();

    supplierThread.join();
    summarizeThread.join();

    System.out.println(sumMap);
  }

  private static void execute03() throws InterruptedException {
    Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap());
    Map<Integer, Long> sumMap = new HashMap<>();

    Thread supplierThread =
        new Thread(
            () -> {
              synchronized (map) {
                IntStream.range(0, END_EXCLUSIVE).forEachOrdered(i -> map.put(i, i));
              }
            });

    Thread summarizeThread =
        new Thread(
            () -> {
              synchronized (map) {
                IntStream.range(0, END_EXCLUSIVE / 1_000)
                    .mapToLong(i -> map.values().stream().mapToInt(Integer::intValue).sum())
                    .forEach(
                        sum -> {
                          int size = map.entrySet().size();
                          sumMap.put(size, sum);
                        });
              }
            });

    supplierThread.start();
    summarizeThread.start();

    supplierThread.join();
    summarizeThread.join();

    System.out.println(sumMap);
  }
}
