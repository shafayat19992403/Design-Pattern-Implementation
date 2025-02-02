public interface VendingMachineState {
    public void collectMoney(int amount);
    public void dispenseProduct();
    public void returnMoney();
    public void reStock(int newPieces);
}
