package Components;

public class IntelProcessorThree implements Processor {

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

    public IntelProcessorThree() {
        name = "Intel 11th generation Core i9";
        price = 65000;
    }
}
