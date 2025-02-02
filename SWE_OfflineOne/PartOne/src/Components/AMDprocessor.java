package Components;

public class AMDprocessor implements Processor {

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

    public AMDprocessor() {
        name = "AMD Ryzen 7 5700X";
        price = 28000;
    }
}
