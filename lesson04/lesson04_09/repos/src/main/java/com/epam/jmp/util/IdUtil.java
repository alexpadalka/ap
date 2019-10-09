package com.epam.jmp.util;

import java.util.Stack;

public class IdUtil {

  private Stack<Integer> ids;
  private Integer counter;

  public IdUtil() {
    this(new Stack<>());
  }

  public IdUtil(Stack<Integer> ids) {
    this.ids = ids;
    this.counter = 0;
  }

  public void releaseId(Integer id) {
    ids.push(id);
  }

  public Integer getFirstAvailableId() {
    if (!ids.empty()) {
      return ids.pop();
    }

    counter++;

    return counter;
  }
}
