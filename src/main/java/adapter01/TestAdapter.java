package adapter01;

public class TestAdapter {
    public static void main(String[] args) {
        //简单适配器
        //情景：想要访问接口A却没有合适方法，接口B中找到合适方法，我们又只能访问A接口，并且不能改变A原来实现
        //实现：创建适配器Adapter实现接口A，同时继承B的实现类，重写适配器中A接口实现即可
        ServiceA a = new Adapter();
        System.out.println(a.methodA());
    }
}
