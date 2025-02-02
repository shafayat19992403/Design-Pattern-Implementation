import java.util.Scanner;

public class VendingMachine {
    private VendingMachineState currentState;
    public int ProductPrice;
    public int ProductPieces;
    public int fund;
    public VendingMachine(int ProductPrice,int ProductPieces){
        currentState=new ReadyState(this);
        this.ProductPieces=ProductPieces;
        this.ProductPrice=ProductPrice;
        fund=0;
    }

    public VendingMachineState getCurrentState(){
        return currentState;
    }

    public void setCurrentState(VendingMachineState state){
        currentState=state;
    }

    public void collectMoney(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Amount of money: ");
        int amount=Integer.parseInt(input.nextLine());
        currentState.collectMoney(amount);
    }

    public void dispenseProduct(){
        currentState.dispenseProduct();
    }
    public void returnMoney(){
        currentState.returnMoney();
    }
    public void reStock(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Amount of Product Pieces: ");
        int amount=Integer.parseInt(input.nextLine());
        currentState.reStock(amount);
    }
}
