public interface Observer {
    public String getName();
    public void change(int previousState,int currentState);
}
