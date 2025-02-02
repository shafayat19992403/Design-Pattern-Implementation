public class OutOfStockState implements VendingMachineState{
    private VendingMachine machine;
    public OutOfStockState(VendingMachine machine){
        this.machine=machine;
    }
    @Override
    public void collectMoney(int amount) {
        System.out.println("The machine is outOfStock Product State.It will not collect money");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("The machine is OutOfStock Product State.It will not dispense product");
    }
    @Override
    public void returnMoney(){
        System.out.println("The machine is OutOfStockState. It will not return any money");
    }
    @Override
    public void reStock(int newPieces) {
        System.out.println("Machine is in restocking state.");
        machine.ProductPieces=newPieces;
        machine.setCurrentState(new ReadyState(machine));
    }

}
