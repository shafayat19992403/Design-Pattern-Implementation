package Builders;

import Components.*;

import java.util.ArrayList;

public class PC {
    private HardDiskDrive hdd;
    private MotherBoard motherBoard;
    private Cooler cooler;
    private ArrayList<GraphicsCard> graphicsCardList;
    private ArrayList<Ram> ramList;
    private Processor processor;
    private DVDDrive dvdDrive;
    private String name;

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public PC(){
        graphicsCardList=new ArrayList<>();
        ramList=new ArrayList<>();
    }
    public DVDDrive getDvdDrive() {
        return dvdDrive;
    }

    protected void setDvdDrive(DVDDrive dvdDrive) {
        this.dvdDrive = dvdDrive;
    }

    public MotherBoard getMotherBoard() {
        return motherBoard;
    }

    protected void setMotherBoard(MotherBoard motherBoard) {
        this.motherBoard = motherBoard;
    }

    public Cooler getCooler() {
        return cooler;
    }

    protected void setCooler(Cooler cooler) {
        this.cooler = cooler;
    }

    public ArrayList<GraphicsCard> getGraphicsCardList() {
        return graphicsCardList;
    }

    protected void setGraphicsCardList(ArrayList<GraphicsCard> graphicsCardList) {
        this.graphicsCardList = graphicsCardList;
    }

    public ArrayList<Ram> getRamList() {
        return ramList;
    }

    protected void setRamList(ArrayList<Ram> ramList) {
        this.ramList = ramList;
    }

    public Processor getProcessor() {
        return processor;
    }

    protected void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public HardDiskDrive getHdd() {
        return hdd;
    }

    protected void setHdd(HardDiskDrive hdd) {
        this.hdd = hdd;
    }

    public void printDetails(){
        System.out.println("Processor: "+processor.getName()+"\tPrice: "+processor.getPrice());
        if(cooler==null)
            System.out.println("Cooler   :Not Included");
        else
            System.out.println("Cooler   : "+cooler.getName()+"\tPrice: "+cooler.getPrice());
        if(dvdDrive==null)
            System.out.println("DVD Drive: Not included");
        else
            System.out.println("DVD Drive: "+dvdDrive.getName()+"\tPrice: "+dvdDrive.getPrice());

        System.out.println("RAMs     : ");
        if(ramList.size()==0)
            System.out.println("Rams Are not enabled");
        else{
            int i=0;
            for(Ram ram : ramList){
                i++;
                System.out.println("RAM "+i+": Frequency: "+ram.getFrequency()+"MHz Memory:"+ram.getMemory()+"GB DDR4 Price:"+ram.getPrice());
            }
        }
        System.out.println("GraphicsCard:");
        if(graphicsCardList.size()==0)
            System.out.println("Graphics Cards Are not enabled");
        else
        {
            int i=0;
            for(GraphicsCard gc:graphicsCardList){
                i++;
                System.out.println("Graphics Card "+i+" Memory: "+gc.getMemory()+"GB Price: "+gc.getPrice());
            }
        }
        System.out.println("Base     :                   Price: 70000");
        System.out.println("HardDiskDrive: "+hdd.getMemory());
        System.out.println("Motherboard: ");

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("                                                                 Base Price: 70000");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("                                                                 Total Price: "+priceOfThisPC());

        if(priceOfThisPC()!=70000){
            boolean isRamAdded=false;
            boolean isGraphicsAdded=false;

            if(ramList.size()>0)
                isRamAdded=true;
            if(graphicsCardList.size()>0)
                isGraphicsAdded=true;

            if(isRamAdded && isGraphicsAdded)
                System.out.println("N.B: Total price is higher because of adding extra RAM and Graphics Card");
            else if(isRamAdded)
                System.out.println("N.B: Total price is higher because of adding extra RAM ");
            else if(isGraphicsAdded)
                System.out.println("N.B: Total price is higher because of adding extra Graphics Card");

        }
    }
    public int priceOfThisPC(){
        int totalPrice=70000;
        totalPrice+=processor.getPrice();
        if(cooler!=null)
            totalPrice+=cooler.getPrice();
        if(dvdDrive!=null)
            totalPrice+=dvdDrive.getPrice();

        for(Ram ram:ramList){
            totalPrice+=ram.getPrice();
        }
        for(GraphicsCard gc: graphicsCardList){
            totalPrice+=gc.getPrice();
        }
        return totalPrice;
    }
}
