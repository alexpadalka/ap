package com.epam.jmp.task02;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.Timeout;

public class TestCalculator {

  @Rule
  public Timeout globalTimeout= new Timeout(750);

  private Calculator calculator;

  @BeforeEach
  public void init() {
    calculator = new Calculator();
  }

  @AfterEach
  public void destroy() {
    calculator = null;
  }

  @Test
  public void testAddition() {
    assertThat(calculator.addition(1.0, 2.0), is(3.0));
    assertThat(calculator.addition(1L, 2L), is(3L));
  }

  @Test
  public void testSubtraction() {
    assertThat(calculator.subtraction(3.0, 2.0), is(1.0));
    assertThat(calculator.subtraction(3L, 2L), is(1L));
  }

  @Test
  public void testMultiplication() {
    assertThat(calculator.multiplication(3.0, 2.0), is(6.0));
    assertThat(calculator.multiplication(3L, 2L), is(6L));
  }

  @Test
  public void testDivision_getException() {
    assertThrows(IllegalArgumentException.class, () -> calculator.division(5.0, 0.0));
    assertThrows(IllegalArgumentException.class, () -> calculator.division(5L, 0L));
  }

  @Test
  public void testDivision() {
    assertThat(calculator.division(6.0d, 3.0d), is(2.0d));
    assertThat(calculator.division(6L, 3L), is(2L));
  }

  @Test
  public void testRoot_getException() {
    assertThrows(IllegalArgumentException.class, () -> calculator.root(5.0, 0.0));
    assertThrows(IllegalArgumentException.class, () -> calculator.root(5L, 0L));
  }

  @Test
  public void testRoot() {
    assertThat(calculator.root(4.0, 2.0), is((Double) 2.0));
    assertThat(calculator.root(4L, 2L), is(2.0));
  }

  @Test
  public void testPower_getException() {
    assertThrows(IllegalArgumentException.class, () -> calculator.power(5.0d, 0.0));
    assertThrows(IllegalArgumentException.class, () -> calculator.power(5L, 0L));
  }

  @Test
  public void testPower() {
    assertThat(calculator.power(2.0, 2.0), is((Double) 4.0));
    assertThat(calculator.power(2L, 2L), is(4.0));
  }

  @Test
  public void testIsPrimeNegative() {
    calculator.isPrime(-1001);
  }

  @Test
  public void testIsPrime() {
    assertTimeout(Duration.ofMillis(500), () -> calculator.isPrime(1001));
  }

  @Test
  public void testFibonacci() {
    assertThat(calculator.fibonacci(3), is(2L));
    assertThat(calculator.fibonacci(4), is(3L));
    assertThat(calculator.fibonacci(5), is(5L));
    assertThat(calculator.fibonacci(6), is(8L));
    assertThat(calculator.fibonacci(7), is(13L));
    assertThat(calculator.fibonacci(8), is(21L));
  }
}
