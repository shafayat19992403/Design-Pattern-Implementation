public class ReleaseProductState implements VendingMachineState{

    private VendingMachine machine;
    public ReleaseProductState(VendingMachine machine){
        this.machine=machine;
    }
    @Override
    public void collectMoney(int amount) {
        System.out.println("The machine is releasing Product State.It will not collect money");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("The machine is dispensing product.Enjoy Your Product");
        machine.ProductPieces--;
        machine.fund=0;
        //machine.fund-= machine.ProductPrice;
        if(machine.ProductPieces==0){
            machine.setCurrentState(new OutOfStockState(machine));
        }
        else{
            machine.setCurrentState(new ReadyState(machine));
            ////machine.setCurrentState(new ReturnMoneyState(machine));
            //machine.setCurrentState(new ReleaseProductState(machine));
        }
    }
    @Override
    public void returnMoney(){
        System.out.println("The machine is releasing product. It will not return any money");
        //machine.setCurrentState(new ReturnMoneyState(machine));

    }
    @Override
    public void reStock(int newPieces) {
        System.out.println("Machine is in release Product state. It will not reStock");
    }
}
