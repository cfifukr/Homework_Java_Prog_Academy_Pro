package TaskThree;

import java.io.Serializable;

public class Person implements Serializable {
    @Save
    private String name;
    @Save
    private String lastName;
    private int age;


    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.age = -1;
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
