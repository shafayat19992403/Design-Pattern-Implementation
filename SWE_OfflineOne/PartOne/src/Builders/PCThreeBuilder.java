package Builders;

import Builders.Builder;
import Components.*;

public class PCThreeBuilder implements Builder {
    PC pc=new PC();

    @Override
    public void setName() {
        pc.setName("Builders.PC type-3");
    }

    @Override
    public void setBase() {
        pc.setHdd(new HardDiskDrive());
        pc.setMotherBoard(new MotherBoard());
    }

    @Override
    public void setCooler() {

        pc.setCooler(null);
    }

    @Override
    public void setDVDDrive() {
        pc.setDvdDrive(new DVDDrive());
    }

    @Override
    public void addGraphicsCard(GraphicsCard gc) {
        pc.getGraphicsCardList().add(gc);
    }

    @Override
    public void setProcessor() {
        pc.setProcessor(new IntelProcessorThree());
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
