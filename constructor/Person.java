package Assignment9.Level1;

public class Person {

    String name;
    int age;
    float height;

    Person(){
        name="";
        age=0;
        height=0.0f;
    }
    Person(String name,int age,float height){
        this.name=name;
        this.age=age;
        this.height=height;

        System.out.println("Paramatrized constructor called!!");
    }

    Person(Person ob){
        this.name=ob.name;
        this.age=ob.age;
        this.height=ob.height;

        System.out.println("Copy constructor called!!");
    }

    public static void main(String[] args) {

        Person ob=new Person("harsh",22,5.10f);

        Person ob1=new Person(ob);



    }

}
