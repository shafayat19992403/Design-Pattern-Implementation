package Builders;

import Components.*;

public interface Builder {
    public void setBase();
    public void setCooler();
    public void setDVDDrive();
    public void addGraphicsCard(GraphicsCard gc);
    public void setProcessor();
    public void addRam(Ram ram);
    public void setName();
    PC getPC();
    public void reset();
}

