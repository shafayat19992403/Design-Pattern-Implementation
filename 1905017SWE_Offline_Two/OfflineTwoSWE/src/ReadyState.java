public class ReadyState implements VendingMachineState{
    private VendingMachine machine;
    public ReadyState(VendingMachine machine){
        this.machine=machine;
        //System.out.println("In ready state");
    }
    @Override
    public void collectMoney(int amount) {
        machine.fund+=amount;
        System.out.println("Collected "+amount+"tk"+"  New Fund: "+machine.fund);
        if(machine.fund<machine.ProductPrice)
        {
            System.out.println("Insufficient Fund. Please Enter additional "+(machine.ProductPrice-amount)+"");

        }
        else if(machine.fund==machine.ProductPrice){
            machine.setCurrentState(new ReleaseProductState(machine));
        }
        else{
            machine.setCurrentState(new ReturnMoneyState(machine));
            //machine.setCurrentState(new ReleaseProductState(machine));
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Machine is in collecting Money State. Dispensing Product is not possible");
    }

    @Override
    public void returnMoney(){
        System.out.println("Machine is in collecting money state. It will not return any money");
    }

    @Override
    public void reStock(int newPieces) {
        System.out.println("Machine is in collecting money state. It will not reStock");
    }
}
