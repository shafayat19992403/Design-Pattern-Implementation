import java.util.ArrayList;

public class ProjectManager implements EmployerInterface{
    String name;
    String role;
    String project;
    ArrayList<Developer> developerArrayList;

    public ProjectManager(String name,String project){
        this.name=name;
        this.project=project;
        role="Project Manager";
        developerArrayList=new ArrayList<>();
    }

    @Override
    public void showDetails() {
        System.out.println("Name : "+getName());
        System.out.println("Role : "+getRole());
        System.out.println("Current Project :"+getProject());
        System.out.println("Number of Supervisees "+developerArrayList.size());
    }

    public boolean addDeveloper(Developer dev){
        //if(dev.project.equalsIgnoreCase(getProject()))
            //System.out.println("Already added to this project");
        //else{
        for(Developer d:developerArrayList){
            if(dev.getName().equalsIgnoreCase(d.getName())){
                return false;
            }
        }

        developerArrayList.add(dev);
        return true;
       // }
    }

    public boolean removeDeveloper(String name){
        for(Developer dev:developerArrayList){
            if(dev.getName().equalsIgnoreCase(name)) {
                developerArrayList.remove(dev);
                System.out.println("Removing Developer " + dev.getName());
                return true;
            }
        }
        System.out.println("There is no developer named "+name+" in this project.");
        return false;
    }

    public void removeAllDeveloper(){
        while(developerArrayList.size()!=0){
            System.out.println("Removing Developer "+developerArrayList.get(0).getName());
            developerArrayList.remove(0);

        }
        System.out.println("Removed All Developers of Project "+getProject());
    }

    @Override
    public void hierarchy(int t) {
        for(int i=0;i<t;i++){
            System.out.print("\t");
        }
        System.out.println("- "+getName()+" ("+getProject()+")");
        for(Developer dev: developerArrayList){
            dev.hierarchy(t+1);
        }
    }

    @Override
    public void print(boolean isHierarchy) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public ArrayList<Developer> getDeveloperArrayList() {
        return developerArrayList;
    }

    public void setDeveloperArrayList(ArrayList<Developer> developerArrayList) {
        this.developerArrayList = developerArrayList;
    }
}
