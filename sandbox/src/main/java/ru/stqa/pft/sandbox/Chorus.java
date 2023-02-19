package ru.stqa.pft.sandbox;

public class Chorus {
    public static void main(String[] args) {
        Pet[] singer = new Pet[3];
        singer[0] = new Dog();
        singer[1] = new Cat();
        singer[2] = new Cow();
        for (Pet p : singer)
            p.voice();
    }
}