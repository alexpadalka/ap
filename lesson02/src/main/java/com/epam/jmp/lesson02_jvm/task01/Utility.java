package com.epam.jmp.lesson02_jvm.task01;

import java.util.ArrayList;
import java.util.List;

public class Utility {

  public static void generateOOM_HeapSpace_1() {
    int size = 100;
    while (true) {
      int[] array = new int[size];
      size *= 5;
    }
  }

  public static void generateOOM_HeapSpace_2() {
    CustomMemoryLeak obj1 = new CustomMemoryLeak();
    while (true) {
      CustomMemoryLeak obj2 = new CustomMemoryLeak();
      obj2.setParent(obj1);
      obj1 = obj2;
    }
  }

  public static void generateOOM_Metaspace() {
    List<Class<?>> list = new ArrayList<>();
    while (true) {
      CustomClassLoader classLoader = new CustomClassLoader();
      Class<?> aClass = null;
      try {
        aClass = classLoader.findClass("com.epam.jmp.lesson02_jvm.task01.CustomMemoryLeak");
        list.add(aClass);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    }
  }

  public static void generateSO_Recursive() {
    while (true) {
      CustomMemoryLeak obj = CustomMemoryLeak.getCustomMemoryLeak();
    }
  }

  public static void generateSO_NonRecursive() {
    CustomObject1 object = new CustomObject1();
    System.out.println(object.toString());
  }
}
