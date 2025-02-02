/*
public void setBase();
    public void setCooler();
    public void setDVDDrive();
    public void addGraphicsCard(GraphicsCard gc);
    public void setProcessor();
    public void addRam(Ram ram);
    Builders.PC getPC();
    public void reset();
}

 */

import Builders.Builder;
import Components.*;

public class Director {
    public Builder iBuilder;

    public void constructPC(Builder builder){
        iBuilder=builder;
        iBuilder.setBase();
        iBuilder.setCooler();
        iBuilder.setDVDDrive();
        iBuilder.setProcessor();
        iBuilder.setName();
        //ramAndGPUAdder(iBuilder);
    }
    public void addRam(Ram ram){
        iBuilder.addRam(ram);
    }
    public void addGraphicsCard(GraphicsCard gc){
        iBuilder.addGraphicsCard(gc);
    }
}
