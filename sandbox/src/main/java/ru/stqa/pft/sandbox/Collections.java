package ru.stqa.pft.sandbox;

import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    List<String> languages = Arrays.asList("Java","Python","C++", "C#", "Go","Ruby");
    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }
  }
}
