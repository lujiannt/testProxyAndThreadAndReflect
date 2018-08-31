package Proxy01_static;

/**
 * 静态代理类，代理了student
 */
public class StudentProxy implements Person {
    Student student;

    public StudentProxy() {
        super();
    }

    public StudentProxy(Person student) {
        if(student instanceof  Student)
            this.student = (Student) student;
    }

    @Override
    public void sayName() {
        //执行一些其他方法
        beforeMehtod();
        //执行被代理对象方法
        student.sayName();
    }

    /**
     * 自定义方法
     */
    private void beforeMehtod() {
        System.out.println("beforeMehtod...");
    }
}
