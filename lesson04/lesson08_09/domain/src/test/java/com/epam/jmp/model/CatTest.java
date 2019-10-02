package com.epam.jmp.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CatTest {

  @Test
  public void getVoice() {
    Animal animal = new Cat();
    assertEquals("Meow", animal.voice());
  }
}
