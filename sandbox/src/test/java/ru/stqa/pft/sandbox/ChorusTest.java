package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ChorusTest {
  @Test
  public void testPet(){
    Pet dog = new Dog();
    Assert.assertEquals("Gav-gav!", dog.voice());
  }
}
