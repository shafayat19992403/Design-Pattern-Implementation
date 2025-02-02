package Components;

public class IntelProcessorOne implements Processor {

    private String name;
    private int price;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public IntelProcessorOne() {
        name = "Intel 11th generation Core i5";
        price = 20000;
    }
}
