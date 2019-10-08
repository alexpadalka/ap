package com.epam.jmp.task01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class Util {

  private Map<Long, Long> factrorial = new HashMap<>();

  {
    factrorial.put(0L, 1L);
    factrorial.put(1L, 1L);
    factrorial.put(2L, 2L);
    factrorial.put(3L, 6L);
    factrorial.put(4L, 24L);
    factrorial.put(5L, 120L);
  }

  public String concatenateWords(String[] array) {
    return concatenateWords(array, true);
  }

  public String concatenateWords(String[] array, boolean skipEmptyStrings) {
    return Arrays.stream(array).filter(a -> !skipEmptyStrings || !isEmpty(a)).collect(Collectors.joining());
  }

  public boolean isEmpty(String str) {
    return (str == null || str.length() == 0 || "".equals(str));
  }

  public long computeFactorial(long l) {
    if (l < 0) {
      throw new IllegalArgumentException("Only zero or positive numbers");
    }

    if (l > 1000L) {
      try {
        Thread.currentThread().sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    if (factrorial.containsKey(l)) {
      return factrorial.get(l);
    }

    long result = l * computeFactorial(l - 1L);
    factrorial.put(l, result);
    return result;
  }
}
