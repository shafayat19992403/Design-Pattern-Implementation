import Components.*;
import Builders.*;

import java.util.ArrayList;
import java.util.Scanner;

public class offlineOne {

    public static void main(String[] args) {
        ArrayList<PC> pcList=new ArrayList<>();
        boolean isFirstItr=true;
        while(true) {
            Director director = new Director();
            Builder builder;
            Scanner sc = new Scanner(System.in);
            int input = -1;
            String inputStr = "1";
            //ArrayList<GraphicsCard> graphicsCardsListMain=new ArrayList<>();
            //ArrayList<Ram> ramListMain=new ArrayList<>();

            //Scanner sc=new Scanner(System.in);
            //int input=-1;
            if(isFirstItr) {
                while (!inputStr.equalsIgnoreCase("O")) {
                    System.out.println("Press 'O' to open order:");
                    inputStr = sc.nextLine();
                }
                isFirstItr=false;
            }
            System.out.println("Which type of PC?");
            System.out.println("1.Gaming PC");
            System.out.println("2.PC type-1");
            System.out.println("3.PC type-2");
            System.out.println("4.PC type-3");
            input = Integer.parseInt(sc.nextLine());
            //ramAndGPUAdder(graphicsCardsListMain,ramListMain);

            if (input == 1)
                builder = new GamingPCBuilder();
            else if (input == 2)
                builder = new PCOneBuilder();
            else if (input == 3)
                builder = new PCTwoBuilder();
            else if (input == 4)
                builder = new PCThreeBuilder();
            else
                builder = null;

            director.constructPC(builder);

            System.out.println("Do you want to add Ram or Graphics Card?");
            System.out.println("1.RAM");
            System.out.println("2.Graphics Card");
            System.out.println("Press 'E' to close the order");

            //inputStr="1";
            inputStr = sc.nextLine();
            while (!inputStr.equalsIgnoreCase("E")) {
                //input=Integer.parseInt(sc.nextLine());
                if (inputStr.equalsIgnoreCase("1")) {
                    input = -1;
                    while (input != 3) {
                        System.out.println("Enter Your Preferred Ram:");
                        System.out.println("1. 8GB DDR4 2666MHz");
                        System.out.println("2. 8GB DDR4 3200MHz");
                        System.out.println("3. Exit Ram ");

                        input = Integer.parseInt(sc.nextLine());
                        if (input == 1)
                            director.addRam(new RamLF());
                        else if (input == 2)
                            director.addRam(new RamHF());
                        else if (input == 3)
                            break;
                    }
                } else if (inputStr.equalsIgnoreCase("2")) {
                    input = -1;
                    while (input != 3) {
                        System.out.println("Enter Your Preferred Graphics Card:");
                        System.out.println("1. Graphics Card 2GB");
                        System.out.println("2. Graphics Card 4GB");
                        System.out.println("3. Exit Graphics Card ");
                        input = Integer.parseInt(sc.nextLine());
                        if (input == 1)
                            director.addGraphicsCard(new GraphicsCardLow());
                        else if (input == 2)
                            director.addGraphicsCard(new GraphicsCardHigh());
                        else if (input == 3)
                            break;
                    }
                }
                if(inputStr.equalsIgnoreCase("O"))
                    System.out.println("ERROR: You can not open another order before closing previous one.Press 'E' to close order:");
                System.out.println("Do you want to add Ram or Graphics Card?");
                System.out.println("1.RAM");
                System.out.println("2.Graphics Card");
                System.out.println("Press 'E' to close the order.");
                inputStr = sc.nextLine();
            }


            PC pc = builder.getPC();
            pcList.add(pc);
            /*System.out.println("Do you want to add another Builders.PC? (Y/N)");
            String str=sc.nextLine();
            if(str.equalsIgnoreCase("N"))
                break;
            else if(str.equalsIgnoreCase("Y"))
                continue;
            else*/
            int cmd=addPcPrompt();
            boolean breakFlag=true;
            while(cmd!=0 && cmd !=1)
            {
                if(cmd==0)
                    breakFlag=true;
                else if(cmd==1)
                    breakFlag=false;
                else if(cmd==2)
                {
                    cmd=addPcPrompt();
                }
            }
            if(cmd==0)
            breakFlag=true;
            else if(cmd==1)
                breakFlag=false;

            if(breakFlag) break;
            else continue;
        }

        int itr=1;
        for(PC pc:pcList){
            System.out.println("PC "+itr+" :"+pc.getName());
            pc.printDetails();
            itr++;
            System.out.println();
            System.out.println();
        }
    }
    public static int addPcPrompt(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Do you want to add another PC? (Y/N)");
        String str=sc.nextLine();
        if(str.equalsIgnoreCase("N"))
            return 0;
        else if(str.equalsIgnoreCase("Y"))
            return 1;
        else
            return 2;
    }

}

