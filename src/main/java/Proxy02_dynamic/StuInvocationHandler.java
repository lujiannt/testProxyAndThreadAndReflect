package Proxy02_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StuInvocationHandler<T> implements InvocationHandler {
    T target;

    public StuInvocationHandler() {
        super();
    }

    public StuInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeMehtod();
        method.invoke(target, args);
        return null;
    }

    /**
     * 自定义方法
     */
    private void beforeMehtod() {
        System.out.println("beforeMehtod...");
    }
}
