public class ReturnMoneyState implements VendingMachineState {
    private VendingMachine machine;
    public ReturnMoneyState(VendingMachine machine){
        this.machine=machine;
        //this.machine.setCurrentState(new ReadyState(machine));
    }
    @Override
    public void collectMoney(int amount) {
        System.out.println("The machine is returning money State.It will not collect money");

    }

    @Override
    public void dispenseProduct() {
        System.out.println("The machine is returning money. It will not release product");
    }

    @Override
    public void returnMoney(){
        System.out.println("The machine is returning "+(machine.fund-machine.ProductPrice)+"tk");
        machine.fund= machine.ProductPrice;
        machine.setCurrentState(new ReleaseProductState(machine));
        //machine.setCurrentState(new ReadyState(machine));
    }
    @Override
    public void reStock(int newPieces) {
        System.out.println("Machine is in returning money state. It will not reStock");
    }
}
