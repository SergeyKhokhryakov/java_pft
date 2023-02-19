package ru.stqa.pft.sandbox;

class Dog extends Pet {
  int k = 10;

  @Override
  void voice() {
    System.out.println("Gav-gav!");
  }
}
