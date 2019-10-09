package ap.task01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Random;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestUtil {

  private Util util;
  private Random random;

  @BeforeAll
  public static void load() {
    System.out.println("-> load");
  }

  @BeforeEach
  public void init() {
    System.out.println("-> init");
    util = new Util();
    random = new Random();
  }

  @DisplayName("Test concatenate words without empty strings from Array")
  @Test
  public void testConcatenateWords_whenSendArray_returnStringWithSkippingEmptyString() {
    String [] array = {"", "word1", "", " ", "word2", "", "word3", null, new String(), " ", "word4"};
    String result = util.concatenateWords(array);

    assertEquals("word1 word2word3 word4", result);
  }

  @DisplayName("Test concatenate words witht empty strings from Array")
  @Test
  public void testConcatenateWords_whenSendArray_returnStringWithoutSkippingEmptyString() {
    String [] array = {"", "word1", "", " ", "word2", "", "word3", null, new String(), " ", "word4"};
    String result = util.concatenateWords(array, false);

    assertEquals("word1 word2word3null word4", result);
  }

  @DisplayName("Test is string empty")
  @Test
  public void testIsEmpty_whenSendEmptyString_returnTrue() {
    boolean result = false;

    result = util.isEmpty(null);
    assertTrue(result);

    result = util.isEmpty("");
    assertTrue(result);

    result = util.isEmpty(new String());
    assertTrue(result);
  }

  @DisplayName("Test is string not empty")
  @Test
  public void testIsEmpty_whenSendString_returnFalse() {
    boolean result = true;

    result = util.isEmpty("A");
    assertFalse(result);

    result = util.isEmpty(new String("A"));
    assertFalse(result);
  }

  @DisplayName("Test compute factorial for 5 should return 120")
  @Test
  public void testComputeFactorial_whenComputeFactorialFor5_return120() {
    long result = util.computeFactorial(5L);
    assertEquals(120, result);
  }

  @DisplayName("Test compute factorial for 0 should return 1")
  @Test
  public void testComputeFactorial_whenComputeFactorialFor0_return1() {
    long result = util.computeFactorial(0L);
    assertEquals(1, result);
  }

  @DisplayName("Test compute factorial for random number")
  @Test
  public void testComputeFactorial_whenComputeFactorialForRandomNumber_returnLong() {
    long result = util.computeFactorial((long) random.nextDouble() * 1000);
    assertEquals(1, result);
  }

  @DisplayName("Test compute factorial throw IllegalArgumentException for -1")
  @Test()
  public void testComputeFactorial_whenComputeFactorialForNegativeNumber_thrownIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> util.computeFactorial(-1L));
  }

  @DisplayName("Test compute factorial throw IllegalArgumentException for -5")
  @Test()
  public void testExpectedException() {
    assertThrows(IllegalArgumentException.class, () -> util.computeFactorial(-5L));
  }

  @DisplayName("Test compute factorial without exceed timeout")
  @Test()
  public void testComputeFactorial_whenComputeFactorialWithoutExceedTimeout_returnFactorial() {
    Assertions.assertTimeout(Duration.ofMillis(1500), () -> util.computeFactorial(1001L));
  }

  @DisplayName("Ignored test")
  @Test()
  @Ignore
  public void testNormalizeWord() {

  }

  @AfterEach
  public void finalize() {
    System.out.println("-> finalize");
    util = null;
  }

  @AfterAll
  public static void shutdown() {
    System.out.println("-> shutdown");
  }
}
