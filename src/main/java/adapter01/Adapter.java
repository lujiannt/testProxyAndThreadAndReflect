package adapter01;

public class Adapter extends ServiceBImpl implements ServiceA{
    @Override
    public String methodA() {
        return methodB();
    }
}
