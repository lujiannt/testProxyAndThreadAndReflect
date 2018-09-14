package adapter02;

public class Adapter implements ServiceA{
    private ServiceB serviceB;

    public Adapter(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    @Override
    public String methodA() {
        return serviceB.methodB();
    }
}
