public interface Subject_interface {
    public void register(Observer observer);
    public boolean remove(String name);
    public void notifyAllObservers();
}
