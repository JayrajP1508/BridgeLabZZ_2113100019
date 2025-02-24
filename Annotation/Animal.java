package Bridgelabz_2113100011.Assignment24.Annotations;

public class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }

    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();
    }
}
