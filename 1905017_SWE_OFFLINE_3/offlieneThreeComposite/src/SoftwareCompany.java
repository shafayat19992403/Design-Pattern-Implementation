import java.util.ArrayList;

public class SoftwareCompany{
    String name;
    ArrayList<ProjectManager> projectManagerArrayList;
    int numberOfProjects;

    public SoftwareCompany(String name){
        this.name=name;
        projectManagerArrayList=new ArrayList<>();
        numberOfProjects=0;
    }

    public void showDetails(){
        System.out.println("Company Name : "+name);
        System.out.println("Number of Projects : "+numberOfProjects);
    }

    public void hierarchy(int t){
        for(int i=0;i<t;i++){
            System.out.print("\t");
        }
        System.out.println("- "+getName());
        for(ProjectManager pm : projectManagerArrayList){
            pm.hierarchy(t+1);
        }
    }

    public void print(boolean ishierarchy){
        if(ishierarchy){
            hierarchy(0);
        }else {
            showDetails();
        }
    }

    public boolean addProjectManager(ProjectManager pm){
        for(ProjectManager p : projectManagerArrayList){
            if(pm.getName().equalsIgnoreCase(p.getName()) || pm.getProject().equalsIgnoreCase(p.getProject()))
                return false;
        }
        projectManagerArrayList.add(pm);
        return true;
    }

    public boolean removeProjectManager(String name){
        for(ProjectManager pm : projectManagerArrayList){
            if(pm.getName().equalsIgnoreCase(name)){
                pm.removeAllDeveloper();
                projectManagerArrayList.remove(pm);
                System.out.println("Removing Project Manager "+pm.getName());
                return true;
            }
        }
        System.out.println("There is no Project Manager named "+name);
        return false;
    }

    public void removeAllProjectManagers(){
        while(projectManagerArrayList.size()!=0){
            projectManagerArrayList.get(0).removeAllDeveloper();
            System.out.println("Removing Project Manager named "+projectManagerArrayList.get(0).getName());
            projectManagerArrayList.remove(0);
        }
        System.out.println("Removed All the project managers");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ProjectManager> getProjectManagerArrayList() {
        return projectManagerArrayList;
    }

    public void setProjectManagerArrayList(ArrayList<ProjectManager> projectManagerArrayList) {
        this.projectManagerArrayList = projectManagerArrayList;
    }

    public int getNumberOfProjects() {
        return numberOfProjects;
    }

    public void setNumberOfProjects(int numberOfProjects) {
        this.numberOfProjects = numberOfProjects;
    }


}
