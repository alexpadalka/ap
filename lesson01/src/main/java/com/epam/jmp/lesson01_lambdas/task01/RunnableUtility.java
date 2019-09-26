package com.epam.jmp.lesson01_lambdas.task01;

import java.util.Collection;

public interface RunnableUtility {
  static Runnable getRunnable() {
    return () -> System.out.println("Current thread" + Thread.currentThread().getName() + "\nRunnable");
  }

  static Runnable getRunnable(String s) {
    return () -> System.out.println("Current thread" + Thread.currentThread().getName() + "\nRunnable " + s);
  }

  static Runnable getRunnable(int a, int b) {
    return () -> System.out.println("Current thread" + Thread.currentThread().getName() + "\nRunnable: sum " + (a + b));
  }

  static Runnable getRunnable(Collection collection) {
    return () -> System.out.println("Current thread" + Thread.currentThread().getName() + "\nRunnable: collection " + collection);
  }

}
