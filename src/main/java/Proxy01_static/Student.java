package Proxy01_static;

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
        System.out.println(this.name);
    }
}
