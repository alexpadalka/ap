package ap.task02;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgCalculator {

  private Calculator calculator;

  @BeforeTest
  public void init() {
    calculator = new Calculator();
  }

  @AfterTest
  public void destroy() {
    calculator = null;
  }

  @Test
  public void testAddition() {
    Assert.assertEquals(calculator.addition(1.0, 2.0), 3.0);
    Assert.assertEquals(calculator.addition(1L, 2L), 3L);
  }

  @Test
  public void testSubtraction() {
    Assert.assertEquals(calculator.subtraction(3.0, 2.0), 1.0);
    Assert.assertEquals(calculator.subtraction(3L, 2L), 1L);
  }

  @Test
  public void testMultiplication() {
    Assert.assertEquals(calculator.multiplication(3.0, 2.0), 6.0);
    Assert.assertEquals(calculator.multiplication(3L, 2L), 6L);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDivision_getException1() {
    calculator.division(5.0, 0.0);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDivision_getException2() {
    calculator.division(5L, 0L);
  }

  @Test
  public void testDivision() {
    Assert.assertEquals(calculator.division(6.0d, 3.0d), 2.0d);
    Assert.assertEquals(calculator.division(6L, 3L), 2L);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRoot_getException1() {
    calculator.root(5.0, 0.0);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRoot_getException2() {
    calculator.root(5L, 0L);
  }

  @Test
  public void testRoot() {
    Assert.assertEquals(calculator.root(4.0, 2.0), 2.0);
    Assert.assertEquals(calculator.root(4L, 2L), 2.0);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPower_getException1() {
    calculator.power(5.0d, 0.0);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPower_getException2() {
    calculator.power(5L, 0L);
  }

  @Test
  public void testPower() {
    Assert.assertEquals(calculator.power(2.0, 2.0), 4.0);
    Assert.assertEquals(calculator.power(2L, 2L), 4.0);
  }

  @Test(timeOut = 1000)
  public void testIsPrimeNegative() {
    calculator.isPrime(-1001);
  }

  @Test(timeOut = 500)
  public void testIsPrime() {
    calculator.isPrime(1001);
  }

  @Test
  public void testFibonacci() {
    Assert.assertEquals(calculator.fibonacci(3), 2L);
    Assert.assertEquals(calculator.fibonacci(4), 3L);
    Assert.assertEquals(calculator.fibonacci(5), 5L);
    Assert.assertEquals(calculator.fibonacci(6), 8L);
    Assert.assertEquals(calculator.fibonacci(7), 13L);
    Assert.assertEquals(calculator.fibonacci(8), 21L);
  }
}
