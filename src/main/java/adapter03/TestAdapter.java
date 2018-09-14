package adapter03;


public class TestAdapter {
    public static void main(String[] args) {
        //接口适配器
        //通过用抽象类来实现复杂接口，再让抽象类的子类来重写（子类即为适配器，防止接口臃肿）
        ServiceA a = new Adapter();
        a.methodA();
    }
}
