package com.epam.jmp.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DogTest {

  @Test
  public void getVoice() {
    Animal animal = new Dog();
    assertEquals("R-r-r-r", animal.voice());
  }
}
