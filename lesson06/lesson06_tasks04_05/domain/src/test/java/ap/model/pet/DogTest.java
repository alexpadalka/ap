package ap.model.pet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ap.model.Animal;

class DogTest {


  private Animal animal;

  @BeforeEach
  public void init() {
    animal = new Dog();
    animal.setName("Dog");
    animal.setId(1);
  }

  @Test
  public void testPlay() {
    assertEquals("Dog 'Dog' is playing", animal.play());
  }

  @Test
  public void testVoice() {
    assertEquals("Dog 'Dog' say 'R-r-r-r'", animal.voice());
  }

  @Test
  public void testGetId() {
    assertEquals(1, animal.getId());
  }

}