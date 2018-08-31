package Proxy03_factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler {
    private Object target;
    private static ProxyFactory proxyFactory = null;

    private ProxyFactory() {
        super();
    }

    private void setTarget(Object target) {
        this.target = target;
    }

    private Object getTarget() {
        return target;
    }

    /**
     * 初始化工厂
     *
     * @return
     */
    public static ProxyFactory instanceFactory() {
        if (proxyFactory == null)
            proxyFactory = new ProxyFactory();
        return proxyFactory;
    }

    /**
     * 生成代理对象
     *
     * @return
     */
    public Object getProxy(Object object) {
        if (proxyFactory == null) {
            throw new RuntimeException("工厂未初始化..");
        }else {
            this.setTarget(object);
        }
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyFactory);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
