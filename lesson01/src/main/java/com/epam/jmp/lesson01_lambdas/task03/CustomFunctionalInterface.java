package com.epam.jmp.lesson01_lambdas.task03;

import java.util.List;
import java.util.function.Predicate;

import com.epam.jmp.lesson01_lambdas.task01.RunnableUtility;

@FunctionalInterface
public interface CustomFunctionalInterface<T> {

  List<T> apply(List<T> list, Predicate<T> predicate);

  default void default1() {
    hello();
  }
  default void default2(T t) {
    hello();
    System.out.println(RunnableUtility.getRunnable(t.toString()));
  }

  static void hello() {
    System.out.println("Hello");
  }

  static Integer summarize(List<Integer> list) {
    return list.stream().mapToInt(l -> l).sum();
  }

}
