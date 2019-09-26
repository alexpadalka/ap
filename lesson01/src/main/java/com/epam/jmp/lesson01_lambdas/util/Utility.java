package com.epam.jmp.lesson01_lambdas.util;

import static com.epam.jmp.lesson01_lambdas.util.RandomUtility.generateRandomBoolean;
import static com.epam.jmp.lesson01_lambdas.util.RandomUtility.generateRandomDouble;
import static com.epam.jmp.lesson01_lambdas.util.RandomUtility.generateRandomInteger;
import static com.epam.jmp.lesson01_lambdas.util.RandomUtility.generateRandomString;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

import com.epam.jmp.lesson01_lambdas.task02.Person;
import com.epam.jmp.lesson01_lambdas.task05.Author;
import com.epam.jmp.lesson01_lambdas.task05.Book;
import com.epam.jmp.lesson01_lambdas.task06.A;
import com.epam.jmp.lesson01_lambdas.task08.MagicTree;

public class Utility {

  public static List<Person> getPeople() {
    return Arrays.asList(
        new Person(35, "FFF"),
        new Person(25, "DDD"),
        new Person(20, "CCC"),
        new Person(40, "AAA"),
        new Person(30, "BBB"),
        new Person());
  }

  public static Author[] populateAuthorsWithoutBooks(int size) {
    Author[] authors = new Author[size];

    IntStream.range(0, size)
        .forEach(
            i -> {
              String name = generateRandomString(20);
              Short age = (short) (Math.random() * 60 + 18);
              authors[i] = createAuthor(name, age);
            });

    return authors;
  }

  public static Book[] populateBooksWithoutAuthors(int size) {
    Book[] books = new Book[size];

    IntStream.range(0, size)
        .forEach(
            i -> {
              String title = generateRandomString(50);
              Integer numPages = (int) (Math.random() * 500);
              books[i] = createBook(title, numPages);
            });

    return books;
  }

  public static void createRelationshipBetweenAuthorsAndBooks(Author[] authors, Book[] books) {
    Arrays.stream(books).forEach(book -> addAuthorsToBook(book, authors));
  }

  private static Author createAuthor(String name, short age) {
    Author author = new Author();
    author.setName(name);
    author.setAge(age);
    return author;
  }

  private static Book createBook(String title, int pages) {
    Book book = new Book();
    book.setTitle(title);
    book.setNumPages(pages);
    return book;
  }

  private static void addAuthorsToBook(Book book, Author[] authors) {
    Random random = new Random();
    int minAuthors = 1;
    int maxAuthors = 5;

    int authorSize = random.nextInt(maxAuthors - minAuthors + 1) + minAuthors;
    Set<Integer> indexesUsed = new HashSet<>();

    int maxInclusive = authors.length;

    for (int i = 0; i < authorSize; i++) {
      int index = random.nextInt(maxInclusive);
      while ((indexesUsed.contains(index))) {
        index = random.nextInt(maxInclusive);
      }
      indexesUsed.add(index);
      book.getAuthors().add(authors[index]);
      authors[index].getBooks().add(book);
    }
  }

  public static A createA() {
    A a = new A();

    a.setB(generateRandomBoolean());
    a.setD(generateRandomDouble());
    a.setI(generateRandomInteger());
    a.setS(generateRandomString(10));

    return a;
  }

  public static MagicTree createElement(int value) {
    return createElement(value, Collections.EMPTY_LIST);
  }

  public static MagicTree createElement(int value, MagicTree... elems) {
    return createElement(value, Arrays.asList(elems));
  }

  public static MagicTree createElement(int value, List<MagicTree> list) {
    MagicTree element = new MagicTree(value, list);
    return element;
  }

  public static MagicTree createTree() {
    return new MagicTree(0,
        createElement(1,
            createElement(11),
            createElement(12)),
        createElement(2,
            createElement(21),
            createElement(22)));
  }
}

