import java.util.Scanner;

public class main {
    public static void displayOptions(VendingMachine machine){
        System.out.println("FUND: "+machine.fund);
        System.out.println("1.Collect Money");
        System.out.println("2.Dispense Product");
        System.out.println("3.Return Money");
        System.out.println("4.ReStock");
        System.out.println("5.Exit");
    }
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        System.out.println("Enter The price of the product");
        int price=Integer.parseInt(input.nextLine());
        System.out.println("Enter the amount of products");
        int amountOfProducts=Integer.parseInt(input.nextLine());

        VendingMachine machine=new VendingMachine(price,amountOfProducts);

        while(true){
            displayOptions(machine);
            int userInputChoice=Integer.parseInt(input.nextLine());
            if(userInputChoice==1)
                machine.collectMoney();
            else if(userInputChoice==2)
                machine.dispenseProduct();
            else if(userInputChoice==3)
                machine.returnMoney();
            else if(userInputChoice==4)
                machine.reStock();
            else if(userInputChoice==5)
                break;
        }
    }
}
