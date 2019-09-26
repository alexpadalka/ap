package com.epam.jmp.lesson01_lambdas.task07;

import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;

public class CustomIntStreamCollector implements Consumer<Integer> {

  private Integer sum = 0;
  private Integer max = 0;
  private Integer min = 0;

  private Integer count = 0;

  public static Collector<Integer, ?, CustomIntStreamCollector> collector() {
    return Collector.of(
        CustomIntStreamCollector::new,
        CustomIntStreamCollector::accept,
        CustomIntStreamCollector::merge,
        Characteristics.CONCURRENT, Characteristics.IDENTITY_FINISH);
  }

  private void setupFirstElement(CustomIntStreamCollector s) {
    count = s.count;
    sum = s.sum;
    min = s.min;
    max = s.max;
  }

  private void firstElementSetup(Integer i) {
    count = 1;
    sum += i;
    min = i;
    max = i;
  }

  public CustomIntStreamCollector merge(CustomIntStreamCollector s) {
    if (s.count > 0) {
      if (count == 0) {
        setupFirstElement(s);
      } else {
        sum += s.sum;
        min = Math.min(min, s.min);
        max = Math.min(max, s.max);
        count += s.count;
      }
    }
    return this;
  }

  @Override
  public void accept(Integer i) {
    if (count == 0) {
      firstElementSetup(i);
    } else {
      sum += i;
      min = Math.min(min, i);
      max = Math.max(max, i);
      count++;
    }
  }

  public Integer getAverage() {
    if (count == 0) {
      return 0;
    }
    return Math.floorDiv(sum, count);
  }

  public Integer getSum() {
    return sum;
  }

  public Integer getMax() {
    return max;
  }

  public Integer getMin() {
    return min;
  }

  public Integer getCount() {
    return count;
  }
}
