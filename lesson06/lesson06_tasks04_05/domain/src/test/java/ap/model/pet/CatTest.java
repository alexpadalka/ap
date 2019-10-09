package ap.model.pet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ap.model.Animal;

class CatTest {

  private Animal animal;

  @BeforeEach
  public void init() {
    animal = new Cat();
    animal.setName("Cat");
    animal.setId(1);
  }

  @Test
  public void testPlay() {
    assertEquals("Cat 'Cat' is playing", animal.play());
  }

  @Test
  public void testVoice() {
    assertEquals("Cat 'Cat' say 'Meow'", animal.voice());
  }

  @Test
  public void testGetId() {
    assertEquals(1, animal.getId());
  }
}