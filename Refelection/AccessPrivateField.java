package Bridgelabz_2113100011.Assignment24.Reflections;


import java.lang.reflect.Field;

class Person {
    private int age;

    Person(int age) {
        this.age = age;
    }
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person(22);
        Class<?> cls = person.getClass();
        Field field = cls.getDeclaredField("age");
        field.setAccessible(true);

        System.out.println("Age Before: " + field.get(person));

        field.set(person, 26);

        System.out.print("Age After: " + field.get(person));


    }
}
