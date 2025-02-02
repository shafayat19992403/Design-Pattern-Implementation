package Components;

public class GraphicsCardHigh implements GraphicsCard {

    private int memory;
    private int price;

    public GraphicsCardHigh() {
        memory = 4;
        price = 7600;
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
