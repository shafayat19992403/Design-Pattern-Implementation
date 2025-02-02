import java.util.Scanner;

public class main {
    public static Scanner scanner=new Scanner(System.in);
    public static String getState(int i){
        if(i==0) return "Operational";
        else if(i==1) return "Partially down";
        else if(i==2) return "Fully Down";
        else return "0";
    }
    public static void displayOptions(){
        //System.out.println("\n\n");
        System.out.println("Please choose operational condition");
        System.out.println("1.Operational");
        System.out.println("2.Partially down");
        System.out.println("3.Fully down");
        System.out.println("4.Exit");
        System.out.println("Enter your choice:");

    }
    public static void main(String[] args) {

            int choice;

            ABC_Server abc=new ABC_Server();
            abc.register(new PremiumUser("A"));
            abc.register(new RegularUser("B"));
            System.out.println("Currently, ABC server is fully operational");
            while (true)
            {
                displayOptions();
                choice=scanner.nextInt();
                if(!(choice>=1 && choice<=4)) {
                    System.out.println("Please select valid option");
                    continue;
                }
                else if (choice==4)break;
                else if(choice-1==abc.getCurrentState()){
                    System.out.println("Same State! Please choose different state to proceed");
                    continue;
                }
                else  {
                    String str="";

                    str+="Previous state : "+getState(abc.getCurrentState());

                    str+="\nCurrent State : "+getState(choice-1);

                    System.out.println(str);
                    abc.setCurrentState(choice-1);
                }

            }

        }


}
