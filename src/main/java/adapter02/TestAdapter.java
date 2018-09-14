package adapter02;

public class TestAdapter {
    public static void main(String[] args) {
        //对象适配器
        //原理同上
        ServiceA a = new Adapter(new ServiceBImpl());
        System.out.println(a.methodA());
    }
}
