public class Main
 {
    public static void main(String[] args) {
        Animal myDog = new Dog("Buddy", 3);
        Animal myCat = new Cat("Whiskers", 2);
        Animal myBird = new Bird("Tweety", 1);
        
        myDog.makeSound();
        myCat.makeSound();
        myBird.makeSound();
    }
}

class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age)
     {
        this.name = name;
        this.age = age;
    }
    
    public void makeSound() 
    {
        System.out.println("animal sound");
    }

}

class Dog extends Animal {
    public Dog(String name, int age) 
    {
        super(name, age);
    }
    
    @Override
    public void makeSound() 
    {
        System.out.println("dog barks");
    }
}

class Cat extends Animal {
    public Cat(String name, int age) 
    {
        super(name, age);
    }
    
    @Override
    public void makeSound() {
        System.out.println("cat meows");
    }
}

class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void makeSound() {
        System.out.println("bird chirps");
    }
}


