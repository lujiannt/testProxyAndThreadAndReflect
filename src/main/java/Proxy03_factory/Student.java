package Proxy03_factory;

/**
 * 被代理对象
 */
public class Student implements Person {
    String name;

    public Student() {
        super();
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void sayName() {
        System.out.println("name is " + this.name);
    }

    @Override
    public void showHobby(String hobby) {
        System.out.println("hobby is " + hobby);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
