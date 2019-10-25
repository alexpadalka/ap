package ap.task01;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFactorial extends RecursiveTask<BigInteger> {

  private static Map<Long, BigInteger> cache;

  static {
    cache = new HashMap<>();
    cache.put(0L, BigInteger.valueOf(1L));
    cache.put(1L, BigInteger.valueOf(1L));
    cache.put(2L, BigInteger.valueOf(2L));
    cache.put(3L, BigInteger.valueOf(6L));
    cache.put(4L, BigInteger.valueOf(24L));
    cache.put(5L, BigInteger.valueOf(120L));
  }

  private Long num;

  public ForkJoinFactorial(long num) {
    this.num = num;
  }

  protected BigInteger compute() {
    BigInteger result = cache.get(num);
    if (result != null) {
      return result;
    }

    result = BigInteger.valueOf(num);
    ForkJoinFactorial factorial = new ForkJoinFactorial(num - 1);
    result = result.multiply(factorial.compute());
    cache.put(num, result);

//    System.out.println(Thread.currentThread().getName());

    return result;
  }

  public static BigInteger calculate(long num) {
    ForkJoinFactorial task = new ForkJoinFactorial(num);
    return (new ForkJoinPool()).invoke(task);
  }
}
