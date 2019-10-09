package ap.task02;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Calculator {

  private Map<Long, Long> fibCache = new HashMap<>();

  {
    fibCache.put(1L, 1L);
    fibCache.put(2L, 1L);
    fibCache.put(3L, 2L);
    fibCache.put(4L, 3L);
    fibCache.put(5L, 5L);
    fibCache.put(6L, 8L);
    fibCache.put(7L, 13L);
  }

  public double addition(double a, double b) {
    return a + b;
  }

  public double subtraction(double a, double b) {
    return a - b;
  }

  public double multiplication(double a, double b) {
    return a * b;
  }

  public double division(double a, double b) {
    if (b == 0d) {
      throw new IllegalArgumentException("IllegalArgumentException");
    }

    return a / b;
  }

  public double root(double a, double n) {
    if (a == 0d || n == 0d) {
      throw new IllegalArgumentException("IllegalArgumentException");
    }

    return Math.exp(Math.log(a) / n);
  }

  public double power(double a, double n) {
    if (a == 0d || n == 0d) {
      throw new IllegalArgumentException("IllegalArgumentException");
    }

    return Math.pow(a, n);
  }

  public long addition(long a, long b) {
    return a + b;
  }

  public long subtraction(long a, long b) {
    return a - b;
  }

  public long multiplication(long a, long b) {
    return a * b;
  }

  public long division(long a, long b) {
    if (b == 0l) {
      throw new IllegalArgumentException("IllegalArgumentException");
    }

    return a / b;
  }

  public double root(long a, long n) {
    if (a == 0l || n == 0l) {
      throw new IllegalArgumentException("IllegalArgumentException");
    }

    return Math.exp(Math.log(a) / n);
  }

  public double power(long a, long n) {
    if (a == 0l || n == 0l) {
      throw new IllegalArgumentException("IllegalArgumentException");
    }

    return Math.pow(a, n);
  }

  public boolean isPrime(long a) {
    if (a < 2) {
      try {
        Thread.currentThread().sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    return a > 2 && IntStream.rangeClosed(2, (int) Math.sqrt(a)).noneMatch(n -> (a % n == 0));
  }

  public long fibonacci(long l) {
    if (fibCache.containsKey(l)) {
      return fibCache.get(l);
    }

    if (l == 1 || l == 2) {
      return 1;
    }

    long fib = fibonacci(l - 1) + fibonacci(l - 2);
    fibCache.put(l, fib);
    return fib;
  }
}
