package com.epam.jmp.lesson01_lambdas.task02;

import java.util.Comparator;

public class NameComparator implements PersonComparable {

  @Override
  public Comparator<Person> getComparator() {
    return (o1, o2) -> {
      if (o1 == o2) return 0;
      if (o1 == null) return -1;
      if (o2 == null) return 1;
      return o1.getName().compareTo(o2.getName());
    };
  }

}
