package Components;

public class LiquidCooler implements Cooler {

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

    public LiquidCooler() {
        name = "Liquid Cooler";
        price = 17000;
    }
}
