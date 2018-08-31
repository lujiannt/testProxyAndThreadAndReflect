package Proxy03_factory;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestProxy {
    @Test
    public void test1() {
        //创建一个实例对象，这个对象是被代理的对象
        Person student = new Student("张三");
        Person proxy = (Person) ProxyFactory.instanceFactory().getProxy(student);
        proxy.sayName();
//        proxy.showHobby("吃");
    }

    @Test
    public void test2() {
        //创建一个实例对象，这个对象是被代理的对象
        List<Student> studentList = new ArrayList<>();
        List<Student> proxyList = (List<Student>) ProxyFactory.instanceFactory().getProxy(studentList);
        proxyList.add(new Student("student1"));
        proxyList.add(new Student("student2"));
        System.out.println(proxyList);
    }
}
