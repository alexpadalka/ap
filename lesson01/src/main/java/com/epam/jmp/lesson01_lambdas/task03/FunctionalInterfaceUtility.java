package com.epam.jmp.lesson01_lambdas.task03;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.epam.jmp.lesson01_lambdas.task02.Person;
import com.epam.jmp.lesson01_lambdas.task04.TripleFunction;

public interface FunctionalInterfaceUtility {

  static Supplier<Person> getSupplier() {
    return Person::new;
  }

  static Consumer<Person> getConsumer() {
    return p -> System.out.println("Consumer " + p.toString());
  }

  static Predicate<Person> getPredicate(int age) {
    return p -> p.getAge() >= age;
  }

  static Function<List<Person>, Integer> getPersonFunction() {
    return people ->
        (people == null || people.isEmpty())
            ? 0
            : people.stream().mapToInt(Person::getAge).sum() / people.size();
  }

  static CustomFunctionalInterface<Person> getPersonCustomFunctionalInterface() {
    return (people, predicate) -> people.stream().filter(predicate).collect(Collectors.toList());
  }

  static TripleFunction<Integer, String, String, Person> getTripleFunctionForPopulatingPerson() {
    return (age, name, address) -> {
      Person p = new Person(age, name);
      p.setAddress(address);

      return p;
    };
  }

  static  TripleFunction<Integer, Integer, Integer, Integer> getTripleFunctionForSummarize() {
    return (a, b, c) -> {
      return a + b + c;
    };
  }
}

