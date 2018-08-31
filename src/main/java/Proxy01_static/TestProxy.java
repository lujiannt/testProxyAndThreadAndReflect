package Proxy01_static;

import org.junit.jupiter.api.Test;

public class TestProxy {
    @Test
    public void test1() {
        Person student = new Student("张三");
        Person studentProxy = new StudentProxy(student);
        studentProxy.sayName();
    }
}
