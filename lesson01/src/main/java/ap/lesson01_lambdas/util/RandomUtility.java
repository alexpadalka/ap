package ap.lesson01_lambdas.util;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtility {

  private static Random random = new Random();

  public static String generateRandomString(int maxStringLength) {
    int leftLimit = 49;
    int rightLimit = 122;

    int targetStringLength = (int) (maxStringLength * Math.random());

    return IntStream.range(0, targetStringLength)
        .map(i -> leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1)))
        .mapToObj(randomLimitedInt -> String.valueOf((char) randomLimitedInt))
        .collect(Collectors.joining());
  }

  public static int generateRandomInteger() {
    return generateRandomInteger(null, null);
  }

  public static int generateRandomInteger(Integer start, Integer end) {
    if (start == null) start = 0;
    if (end == null) end = 10;

    return start + random.nextInt((end - start) + 1);
  }

  public static double generateRandomDouble() {
    return generateRandomDouble(null, null);
  }

  public static double generateRandomDouble(Double start, Double end) {
    if (start == null) start = Double.valueOf("0");
    if (end == null) end = Double.valueOf("10");

    return start + (end - start) * random.nextDouble();
  }

  public static boolean generateRandomBoolean() {
    return random.nextBoolean();
  }
}
