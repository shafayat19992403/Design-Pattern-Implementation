package Components;

public class HardDiskDrive implements Base{

    private String memory;
    @Override
    public String getType() {
        return "HDD";
    }
    public void setMemory(String memory){
        this.memory=memory;
    }
    public String getMemory(){
        return memory;
    }
    public HardDiskDrive(){
        memory="1 TB";
    }
}
