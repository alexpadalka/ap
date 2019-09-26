package com.epam.jmp.lesson01_lambdas.task08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MagicTree {

  private int value;
  private List<MagicTree> children = new LinkedList<>();

  public MagicTree(int value, List<MagicTree> children) {
    this.value = value;
    this.children.addAll(children);
  }

  public MagicTree(int value, MagicTree... children) {
    this(value, Arrays.asList(children));
  }

  public int getValue() {
    return value;
  }

  public List<MagicTree> getChildren() {
    return Collections.unmodifiableList(children);
  }

  public Stream<MagicTree> flattened() {
    List<MagicTree> list = new ArrayList<>();
    list.add(this);
    if (!children.isEmpty()) {
      children.forEach(child -> Stream.concat(list.stream(), child.flattened()));
    }
    return list.stream();
  }

  public List<Integer> getAllValues() {
    List<Integer> list = new ArrayList<>();
    list.add(value);
    if (!children.isEmpty()) {
      children.stream().forEach(child -> list.addAll(child.getAllValues()));
    }
    return list;
  }

  public List<Integer> getEvenValues() {
    return getAllValues().stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
  }

  public Optional<Integer> sumOfEvenValues() {
    return Optional.of(getEvenValues().stream().mapToInt(Integer::intValue).sum());
  }

  public Boolean isContains13() {
    return getAllValues().stream().anyMatch(e -> e == 13);
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append("Value = ").append(value).append("\n")
        .append("Children ").append(children).append("\n").toString();
  }
}
