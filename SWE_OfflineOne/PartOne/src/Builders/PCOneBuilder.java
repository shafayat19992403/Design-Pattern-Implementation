package Builders;

import Builders.Builder;
import Components.*;

public class PCOneBuilder implements Builder {
    PC pc=new PC();

    @Override
    public void setName() {
        pc.setName("Builders.PC type-1");
    }
    @Override
    public void setBase() {
        pc.setHdd(new HardDiskDrive());
        pc.setMotherBoard(new MotherBoard());
    }

    @Override
    public void setCooler() {

        pc.setCooler(new CPUCooler());
    }

    @Override
    public void setDVDDrive() {
        pc.setDvdDrive(null);
    }

    @Override
    public void addGraphicsCard(GraphicsCard gc) {
        pc.getGraphicsCardList().add(gc);
    }

    @Override
    public void setProcessor() {
        pc.setProcessor(new IntelProcessorOne());
    }

    @Override
    public void addRam(Ram ram) {
        pc.getRamList().add(ram);
    }

    @Override
    public PC getPC() {
        return pc;
    }

    @Override
    public void reset() {
        pc.setHdd(null);
        pc.setMotherBoard(null);
        pc.setCooler(null);
        pc.setDvdDrive(null);
        pc.getGraphicsCardList().clear();
        pc.getRamList().clear();
        pc.setProcessor(null);
    }
}
