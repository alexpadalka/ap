package com.epam.jmp.lesson03_gc.task05;

public class Helper {

  private static final String CLASS_NAME = "com.epam.jmp.lesson03_gc.task05.TestClass";

  private CacheCustomClassLoader classLoader;

  public Helper() {
    this.classLoader = new CacheCustomClassLoader();
  }

  public void run0501() {
    classLoader.methodInvoke(CLASS_NAME, "print", null);
  }

  public void run0502() {
    this.classLoader = new CacheCustomClassLoader();
    run0501();
  }

  public void run0503(String methodName, String param) {
    this.classLoader = new CacheCustomClassLoader();
    classLoader.methodInvoke(CLASS_NAME, methodName, param);
  }
}
