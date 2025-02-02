import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input=new Scanner(System.in);
    static ArrayList<SoftwareCompany> sc=new ArrayList<>();
    public static int SoftwareCompanyManu(SoftwareCompany s){
        System.out.println("Inside the software company "+s.getName());

        /*for(int i=0;i<s.projectManagerArrayList.size();i++){
            System.out.println((i+1)+". "+s.projectManagerArrayList.get(i).getName()+" Project Name: "+s.projectManagerArrayList.get(i).getProject());
        }*/
        s.hierarchy(0);
        System.out.println("Options: ");
        System.out.println("1.Add Project Manager");
        System.out.println("2.Delete Project Manager");
        System.out.println("3.Enter Project Manager Manu");
        System.out.println("4.Back");

        int select2=Integer.parseInt(input.nextLine());
        return select2;
    }

    public static int projectManagerManu(ProjectManager pm){
        System.out.println("Inside the Project Manager "+pm.getName());

        /*for(int i=0;i<pm.developerArrayList.size();i++){
            System.out.println((i+1)+". "+pm.developerArrayList.get(i).getName());
        }*/
        pm.hierarchy(0);

        System.out.println("Options: ");
        System.out.println("1.Add Developer");
        System.out.println("2.Delete Developer");
        System.out.println("3.Back");
        int select=Integer.parseInt(input.nextLine());
        return select;
    }
    public static void addProjectManager(SoftwareCompany s){
        String name;
        String projectName;
        System.out.println("Enter Project Manager Name :");
        name=input.nextLine();
        System.out.println("Enter Project Name");
        projectName=input.nextLine();

        if(s.addProjectManager(new ProjectManager(name,projectName))==false){
            System.out.println("Project Creation is not possible");
        };
    }

    public static void addDeveloper(ProjectManager pm){
        String name;
        System.out.println("Enter Developer Name :");
        name=input.nextLine();

        if(pm.addDeveloper(new Developer(name,pm.getProject()))==false){
            System.out.println("Developer Creation is not possible");
        }
    }

    public static void deleteProjectManager(SoftwareCompany s){
        String name;
        System.out.println("Enter Project Manager Name: ");
        name=input.nextLine();
        if(s.removeProjectManager(name)==false)
            System.out.println("Project manager not found");;
    }

    public static void deleteDeveloper(ProjectManager pm){
        String name;
        System.out.println("Enter Developer name: ");
        name=input.nextLine();

        if(pm.removeDeveloper(name)==false){
            System.out.println("Developer not found");
        }
    }
    public static int SoftwarePageMenu(){
        System.out.println("The Software Companies currently available are :");
        for(int i=0;i<sc.size();i++){
            //System.out.println((i+1)+". "+sc.get(i).getName());
            sc.get(i).hierarchy(0);
        }
        System.out.println("Options :");
        System.out.println("1. Create New Software Company");
        System.out.println("2. Delete Software Company");
        System.out.println("3. Enter Company Manu");

        int select = Integer.parseInt(input.nextLine());
        return select;

    }
    public static void createNewSoftwareCompany(){
        System.out.println("Enter Name of the Software Company :");
        String name=input.nextLine();
        sc.add(new SoftwareCompany(name));
    }

    public static void deleteSoftwareCompany(){
        System.out.println("Enter the name of the company you want to delete: ");
        String name=input.nextLine();
        int i=-1;
        for(SoftwareCompany s:sc){
            i++;
            if(s.getName().equalsIgnoreCase(name)){
                s.removeAllProjectManagers();
                System.out.println("Removing Software Company "+name);
                sc.remove(i);
                return;
            }
        }
    }

    public static ProjectManager enterProjectManager(SoftwareCompany s){
        System.out.println("Enter the name of the Project Manager ");
        String name=input.nextLine();
        for(ProjectManager pm : s.projectManagerArrayList){
            if(pm.getName().equalsIgnoreCase(name)){
                return pm;
            }
        }
        return null;
    }
    public static SoftwareCompany enterSoftwareCompany(){
        System.out.println("Enter the name of the software company");
        String name= input.nextLine();
        for(SoftwareCompany s : sc){
            if(s.getName().equalsIgnoreCase(name)){
                return s;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        /*SoftwareCompany sc=new SoftwareCompany("Google");
        ProjectManager pm=new ProjectManager("Sahil Sir","SWE");
        pm.addDeveloper(new Developer("Rahi","SWE"));
        pm.addDeveloper(new Developer("Tonmay","SWE"));
        pm.addDeveloper(new Developer("Zulkar","SWE"));
        pm.addDeveloper(new Developer("Zulkar","SWE"));
        sc.addProjectManager(pm);
        ProjectManager pm2=new ProjectManager("Elin Sir","SWEEEE");
        pm2.addDeveloper(new Developer("Saffat","SWEEEE"));
        pm2.addDeveloper(new Developer("Zabin","SWEEEE"));
        sc.addProjectManager(pm2);

        sc.hierarchy(1);
        sc.removeAllProjectManagers();*/


        while(true){
            int select = SoftwarePageMenu();
            if(select == 1) {
                createNewSoftwareCompany();
            }else if(select == 2){
                deleteSoftwareCompany();
            }else if(select == 3){
                SoftwareCompany s=enterSoftwareCompany();

                int select2=-1;
                while(select2!=4){

                    select2=SoftwareCompanyManu(s);
                    if(select2==1){
                        addProjectManager(s);
                    }else if(select2==2){
                        deleteProjectManager(s);
                    }else if(select2==3){



                        ProjectManager pm=enterProjectManager(s);
                        int select3=-1;

                        while(select3!=3){
                            select3=projectManagerManu(pm);
                            if(select3==1){
                                addDeveloper(pm);
                            }else if(select3 == 2){
                                deleteDeveloper(pm);
                            }else if(select3==3){

                            }
                        }




                    }else if(select2==4){

                    }
                }


            }
        }
    }
}