package com.epam.jmp.lesson02_jvm.task01;

import java.util.HashMap;
import java.util.Map;

public class CustomMemoryLeak {

  private CustomMemoryLeak parent;
  private Map<String, String> map = new HashMap<>();
  private byte[] data = new byte[50 * 1024 * 1024];
//  private byte[] data = new byte[50];

  public CustomMemoryLeak() {
  }

  public void prepare() {
    this.map.put("TIME_CREATION", "" + System.nanoTime());
  }

  public void setParent(CustomMemoryLeak parent) {
    this.parent = parent;
    this.map.put("TIME_CREATION", "" + System.nanoTime());
  }

  public CustomMemoryLeak(CustomMemoryLeak parent) {
    this.parent = parent;
  }

  public static CustomMemoryLeak getCustomMemoryLeak() {
    // run with -XX:+HeapDumpOnOutOfMemoryError
    return new CustomMemoryLeak(getCustomMemoryLeak());
  }
}
