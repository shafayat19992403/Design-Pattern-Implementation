import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input=new Scanner(System.in);
    static int coffeeSelected[]={0,0,0,0};
    public static void printCoffeeList(){

        System.out.println("0.Exit");
        System.out.println("1.Americano");
        System.out.println("2.Espresso");
        System.out.println("3.Cappuccino");
        System.out.println("4.Mocha");
        System.out.println("Select a coffee[0-4]");
    }
    public static Integer getQuantity(Coffee coffee){
        System.out.println("Enter amount of "+coffee.getName()+": ");
        Integer temp=Integer.parseInt(input.nextLine());
        return temp;
    }
    public static void main(String[] args) {
        ArrayList<Coffee> coffeeList=new ArrayList<>();
        ArrayList<Integer> amountList=new ArrayList<>();
        Coffee coffee;
        Integer amount;

        for(int i=0;i<4;i++){
            amountList.add(0);
        }

        for(int i=0;i<4;i++){
            coffeeList.add(null);
        }

        while(true){


            printCoffeeList();
            int select=-1;
            boolean isError=false;
            while(select==-1 || !(select>=0 && select<=4)){
                if(isError)
                    System.out.println("Please enter valid input [0-4]");

                select = Integer.parseInt(input.nextLine());
                isError=true;
            }




            if(select==1){
                coffee=new Americano(new BlackCoffee());
            }else if(select==2){
                coffee=new Espresso(new BlackCoffee());
            }else if(select==3){
                coffee=new Cappuccino(new MilkCoffee());
            }else if(select==4){
                coffee=new Mocha(new MilkCoffee());
            }else if(select==0){
                //coffee=null;
                break;
            }
            else{
                coffee=new BlackCoffee();
            }

            amount = getQuantity(coffee);

            if(coffeeSelected[select-1]==0) {
                //coffeeList.add(coffee);
                coffeeList.set(select-1,coffee);
                amountList.set(select-1,amountList.get(select-1)+amount);
                coffeeSelected[select-1]=1;
            }else{
                amountList.set(select-1,amountList.get(select-1)+amount);
                //amountList.get(select)++;
            }
        }




        for(int i=0;i<4;i++){

            if(coffeeList.get(i)==null)
                continue;

            coffee=coffeeList.get(i);
            amount=amountList.get(i);
            System.out.println();
            System.out.println(coffee.getName()+" :");
            System.out.println(coffee.getDescription());
            System.out.println("Ingredient List:");
            for(Ingredient ing:coffee.getIngredientsList()){
                System.out.println(ing);
            }
            System.out.println("Quantity :"+amount);
            System.out.println("The cost is "+coffee.cost()*amount);
        }
    }
}