package Components;

public class GraphicsCardLow implements GraphicsCard {

    private int memory;
    private int price;

    public GraphicsCardLow() {
        memory = 2;
        price = 6500;
    }

    @Override
    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getMemory() {
        return memory;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
