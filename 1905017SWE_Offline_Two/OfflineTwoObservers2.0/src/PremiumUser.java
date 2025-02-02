import java.util.Scanner;

public class PremiumUser implements Observer{
    private String name;
    private boolean isUsingBothServers;

    public PremiumUser(String name){
        this.name=name;
        isUsingBothServers=false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsingBothServers(boolean usingBothServers) {
        isUsingBothServers = usingBothServers;
    }

    public boolean isUsingBothServers() {
        return isUsingBothServers;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void change(int previousState, int currentState) {
        Scanner scanner=new Scanner(System.in);
        int choice;
        System.out.println("Premium User :"+getName());
        if(previousState==0 && currentState==1){
            while(true){
                System.out.println("1. Do you want to use both ABC and DEF Server? (partially)");
                System.out.println("2. Do you want to use fully DEF server?");
                System.out.println("Choose an option:");
                choice=scanner.nextInt();
                if(choice == 1 || choice == 2) break;
                else {
                    System.out.println("Invalid choice.Please enter a valid choice");
                }
            }
            if(choice==1) {
                isUsingBothServers=true;
                System.out.println("You are using both servers");
            }
            else if(choice==2){
                System.out.println("You are only using DEF Server");
            }else{

            }
        }
        else if(previousState==0 && currentState == 2){
            setUsingBothServers(false);
            System.out.println("ABC Server is fully down. The service is now shifted to DEF Server");
        }
        else if(previousState==1 && currentState == 0){
            setUsingBothServers(false);
            System.out.println("You are using ABC Server");
        }
        else if(previousState==1 && currentState == 2){
            if(isUsingBothServers){
                System.out.println("All services are shifted to DEF server");
                setUsingBothServers(false);
            }
            else
                System.out.println("You were already using DEF Server");
        }
        else if(previousState==2 && currentState==0){
            System.out.println("You are using ABC Server");
        }
        else if(previousState==2 && currentState == 1){
            System.out.println("you are using DEF Server");
        }

    }
}
