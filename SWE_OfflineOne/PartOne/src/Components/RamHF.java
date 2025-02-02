package Components;

public class RamHF implements Ram{
    private int price;
    private int frequency;
    private int memory;
    @Override
    public void setPrice(int price) {
        this.price=price;
    }

    @Override
    public void setFrequency(int frequency) {
        this.frequency=frequency;
    }

    @Override
    public void setMemory(int memory) {
        this.memory=memory;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getFrequency() {
        return frequency;
    }

    @Override
    public int getMemory() {
        return memory;
    }

    public RamHF(){
        price=2950;
        frequency=3200;
        memory=8;
    }
}

