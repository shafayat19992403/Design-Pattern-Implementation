import java.util.Scanner;

public class RegularUser implements Observer{
    private String name;
    private boolean isFullyFunctional;
    private int bill;

    public RegularUser(String name){
        this.name=name;
        isFullyFunctional=false;
        bill=0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFullyFunctional() {
        return isFullyFunctional;
    }

    public void setFullyFunctional(boolean fullyFunctional) {
        isFullyFunctional = fullyFunctional;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public int getBill() {
        return bill;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void change(int previousState, int currentState) {
        Scanner scanner=new Scanner(System.in);
        int choice;
        System.out.println("Regular User :"+getName());
        if(previousState==0 && currentState==1){
            while(true){
                System.out.println("1. Do you want to use  ABC with limited functionality");
                System.out.println("2. Do you want to use full functionality using  DEF server? (USD 20/hour)");
                System.out.println("Choose an option:");
                choice=scanner.nextInt();
                if(choice == 1 || choice == 2) break;
                else {
                    System.out.println("Invalid choice.Please enter a valid choice");
                }
            }
            if(choice==1) {
                setFullyFunctional(false);
                System.out.println("You are using ABC Server with limited functionality");
            }
            else if(choice==2){
                setFullyFunctional(true);
                bill++;
                System.out.println("You are only using DEF Server and all of your data is copied to DEF Server");
            }else{

            }
        }
        else if(previousState==0 && currentState == 2){
            while(true){
                System.out.println("Do you want to pay USD 20/hour to have full functionality using DEF server?");
                System.out.println("1.Yes");
                System.out.println("2.No");
                System.out.println("Choose an option: ");
                choice=scanner.nextInt();
                if(choice == 1 || choice == 2) break;
                else {
                    System.out.println("Invalid choice.Please enter a valid choice");
                }
            }
            if(choice==1)
            {
                setFullyFunctional(true);
                bill++;
                System.out.println("All your data are copied to DEF server and you can now use full functionality of DEF server");
            }

            else {
                System.out.println("Sorry! There will not be any service available");
            }
        }
        else if((previousState==1||previousState==2) && currentState==0)
        {
            if(isFullyFunctional()){
                System.out.println("Your bill is "+bill*20);
                setFullyFunctional(false);
                bill=0;
            }
            System.out.println("All services of ABC server are available and you will not have to pay anymore");
        }

        else if(previousState==1 && currentState==2)
        {
            if(isFullyFunctional()){
                System.out.println("You are enjoying all functionality using DEF server");
                bill++;
            }
            else
                System.out.println("Sorry! There will not be any service available");
        }


        else if(previousState == 2 && currentState==1)
        {
            if(isFullyFunctional()){
                System.out.println("You are enjoying all functionality using DEF server");
                bill++;
            }
            else
                System.out.println("You are having limited functionality using ABC server");
        }

    }
}
