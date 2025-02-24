package Bridgelabz_2113100011.Assignment24.Reflections;


class Student {
    private String name;
    private int age;

    Student() {
        name = null;
        age = 0;
    }

    void displayMessage(){
        System.out.println("Student displayMessage called..");
    }

}

public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Student.class;

        Object ob = cls.getDeclaredConstructor().newInstance();

        Student student=(Student) ob;

       student.displayMessage();
    }
}
