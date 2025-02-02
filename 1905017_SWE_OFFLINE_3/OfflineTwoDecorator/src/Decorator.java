public abstract class Decorator extends Coffee{
    @Override
    public abstract String getDescription();

    @Override
    public abstract double cost();

    public abstract Coffee getCoffee();
}
