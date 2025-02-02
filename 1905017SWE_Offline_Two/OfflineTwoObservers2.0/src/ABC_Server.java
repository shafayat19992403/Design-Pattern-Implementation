import java.util.ArrayList;
import java.util.List;

public class ABC_Server implements Subject_interface{
    private List<Observer> observerList;
    private int previousState;
    private int currentState;

    public ABC_Server(){
        observerList=new ArrayList<>();
        previousState=0;
        currentState=0;
    }

    public void setCurrentState(int currentState) {
       // this.currentState = currentState;
        setPreviousState(this.currentState);
        this.currentState=currentState;
        notifyAllObservers();

    }

    public void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }

    public void setPreviousState(int previousState) {
        this.previousState = previousState;
    }

    public int getCurrentState() {
        return currentState;
    }

    public int getPreviousState() {
        return previousState;
    }

    public List<Observer> getObserverList() {
        return observerList;
    }

    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public boolean remove(String name) {
        int index=-1;

        for(int i=0;i<observerList.size();i++){
            if(observerList.get(i).getName().equalsIgnoreCase(name)){
                index=i;
            }
        }

        if(index == -1)
        {
            System.out.println("Invalid Delete Request");
            return false;
        }
        else
        {
            System.out.println("Successfully Deleted");
            observerList.remove(observerList.get(index));
        }
        return true;
    }

    @Override
    public void notifyAllObservers() {
        for(int i=0;i<observerList.size();i++){
            observerList.get(i).change(previousState,currentState);
        }
    }
}
