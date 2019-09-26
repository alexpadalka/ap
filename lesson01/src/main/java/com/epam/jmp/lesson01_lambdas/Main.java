package com.epam.jmp.lesson01_lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.epam.jmp.lesson01_lambdas.task01.RunnableUtility;
import com.epam.jmp.lesson01_lambdas.task02.AgeComparator;
import com.epam.jmp.lesson01_lambdas.task02.NameComparator;
import com.epam.jmp.lesson01_lambdas.task02.Person;
import com.epam.jmp.lesson01_lambdas.task03.CustomFunctionalInterface;
import com.epam.jmp.lesson01_lambdas.task03.FunctionalInterfaceUtility;
import com.epam.jmp.lesson01_lambdas.task05.Author;
import com.epam.jmp.lesson01_lambdas.task05.Book;
import com.epam.jmp.lesson01_lambdas.task06.CustomAAccumulator;
import com.epam.jmp.lesson01_lambdas.task06.CustomACollector;
import com.epam.jmp.lesson01_lambdas.task07.CustomIntStreamCollector;
import com.epam.jmp.lesson01_lambdas.task08.MagicTree;
import com.epam.jmp.lesson01_lambdas.util.Utility;

public class Main {

  public static void main(String[] args) {
    executeTask01();
    executeTask02();
    executeTask03();
    executeTask04();
    executeTask05();
    executeTask06();
    executeTask07();
    executeTask08();
  }

  private static void executeTask01() {
    execute(RunnableUtility.getRunnable());
    execute(RunnableUtility.getRunnable("t2"));
    execute(RunnableUtility.getRunnable(5, 6));
    execute(RunnableUtility.getRunnable(Arrays.asList("s1", "s2")));
  }

  private static void executeTask02() {
    List<Person> people = Utility.getPeople();

    execute(RunnableUtility.getRunnable(people));

    execute(
        RunnableUtility.getRunnable(Person.comparing(people, new AgeComparator().getComparator())));
    execute(
        RunnableUtility.getRunnable(
            Person.comparing(people, new NameComparator().getComparator())));

  }

  private static void executeTask03() {
    Supplier<Person> supplier = FunctionalInterfaceUtility.getSupplier();
    execute(RunnableUtility.getRunnable(supplier.get().toString()));

    FunctionalInterfaceUtility.getConsumer().accept(FunctionalInterfaceUtility.getSupplier().get());

    List<Person> people = Utility.getPeople();

    Predicate<Person> predicate = FunctionalInterfaceUtility.getPredicate(30);
    execute(
        RunnableUtility.getRunnable(
            people.stream().filter(predicate).collect(Collectors.toList())));

    execute(
        RunnableUtility.getRunnable(
            "Averange age is "
                + FunctionalInterfaceUtility.getPersonFunction().apply(people).toString()));

    execute(
        RunnableUtility.getRunnable(
            FunctionalInterfaceUtility.getPersonCustomFunctionalInterface()
                .apply(people, predicate)));

    predicate = p -> "AAA".equalsIgnoreCase(p.getName());
    execute(
        RunnableUtility.getRunnable(
            FunctionalInterfaceUtility.getPersonCustomFunctionalInterface()
                .apply(people, predicate)));

    predicate = p -> 20 <= p.getAge() && p.getAge() <= 30;
    execute(
        RunnableUtility.getRunnable(
            FunctionalInterfaceUtility.getPersonCustomFunctionalInterface()
                .apply(people, predicate)));

    predicate =
        new Predicate<Person>() {
          @Override
          public boolean test(Person person) {
            return "AAA".compareTo(person.getName()) < 0 && "FFF".compareTo(person.getName()) > 0;
          }
        };
    execute(
        RunnableUtility.getRunnable(
            FunctionalInterfaceUtility.getPersonCustomFunctionalInterface()
                .apply(people, predicate)));

    FunctionalInterfaceUtility.getPersonCustomFunctionalInterface().default1();
    FunctionalInterfaceUtility.getPersonCustomFunctionalInterface().default2(people.get(0));
    CustomFunctionalInterface.hello();

    execute(
        RunnableUtility.getRunnable(
            CustomFunctionalInterface.summarize(
                people.stream()
                    .mapToInt(Person::getAge)
                    .boxed()
                    .collect(Collectors.toList()))
                .toString()));

  }

  private static void executeTask04() {
    Person p = FunctionalInterfaceUtility.getTripleFunctionForPopulatingPerson().apply(23, "ZZZ", "address1");
    execute(RunnableUtility.getRunnable("Person " + p.toString()));

    execute(RunnableUtility.getRunnable(5, 6));
    Integer s = FunctionalInterfaceUtility.getTripleFunctionForSummarize().apply(5, 6, 0);
    execute(RunnableUtility.getRunnable(s.toString()));
  }

  private static void executeTask05() {
    Author[] authors = Utility.populateAuthorsWithoutBooks(15);
    Book[] books = Utility.populateBooksWithoutAuthors(15);
    Utility.createRelationshipBetweenAuthorsAndBooks(authors, books);

    execute(RunnableUtility.getRunnable(Arrays.asList(authors)));
    execute(RunnableUtility.getRunnable(Arrays.asList(books)));

    Supplier<Stream<Book>> bookStreamSupplier = () -> Arrays.stream(books);

    execute(
        RunnableUtility.getRunnable(
            bookStreamSupplier
                .get()
                .filter(book -> book.getNumPages() > 200)
                .collect(Collectors.toList())));

    execute(
        RunnableUtility.getRunnable(
            bookStreamSupplier
                .get()
                .min(Comparator.comparing(Book::getNumPages))
                .get()
                .toString()));
    execute(
        RunnableUtility.getRunnable(
            bookStreamSupplier
                .get()
                .max(Comparator.comparing(Book::getNumPages))
                .get()
                .toString()));

    execute(
        RunnableUtility.getRunnable(
            bookStreamSupplier
                .get()
                .sorted(Comparator.comparing(Book::getNumPages))
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList())));

    execute(
        RunnableUtility.getRunnable(
            bookStreamSupplier
                .get()
                .filter(book -> book.getAuthors().size() == 1)
                .collect(Collectors.toList())));

    execute(
        RunnableUtility.getRunnable(
            bookStreamSupplier.get().map(Book::getTitle).collect(Collectors.toList()).toString()));

    List<Author> authorList = new ArrayList<>();
    bookStreamSupplier
        .get()
        .map(Book::getAuthors)
        .collect(Collectors.toList())
        .forEach(authorList::addAll);

    execute(
        RunnableUtility.getRunnable(
            authorList.stream().distinct().collect(Collectors.toList()).toString()));
  }

  private static void executeTask06() {
    CustomACollector collect = Stream.iterate(0, i -> i + 1).limit(1_000).map(i -> Utility.createA()).collect(new CustomACollector());
    CustomAAccumulator accumulator = collect.getAccumulator();
    execute(RunnableUtility.getRunnable("Size " + (accumulator.getCountIsB() + accumulator.getCountNonB())));
    execute(RunnableUtility.getRunnable("Double sum " + accumulator.sumD()));
    execute(RunnableUtility.getRunnable("Integer sum " + accumulator.sumI()));
  }

  private static void executeTask07() {
    CustomIntStreamCollector collect = Stream.iterate(0, i -> i + 10).limit(1_000).parallel().collect(CustomIntStreamCollector.collector());
    execute(RunnableUtility.getRunnable("Average - " + collect.getAverage()));
    execute(RunnableUtility.getRunnable("Maximum - " + collect.getMax()));
    execute(RunnableUtility.getRunnable("Minimum - " + collect.getMin()));
  }

  private static void executeTask08() {
    MagicTree tree = Utility.createTree();
    execute(RunnableUtility.getRunnable(tree.getAllValues()));
    execute(RunnableUtility.getRunnable(tree.getEvenValues()));
    execute(RunnableUtility.getRunnable("Sum - " + tree.sumOfEvenValues().orElse(0)));
    execute(RunnableUtility.getRunnable("Is contain 13 - " + tree.isContains13()));
  }

  private static void execute(Runnable task) {
    new Thread(task).start();
  }

}
