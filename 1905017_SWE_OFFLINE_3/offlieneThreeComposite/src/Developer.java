public class Developer implements EmployerInterface{
    String name;
    String role;
    String project;

    public Developer(String name,String project){
        this.name=name;
        this.project=project;
        role="Developer";
    }

    @Override
    public void showDetails() {
        System.out.println("Name : "+name);
        System.out.println("Role : "+role);
        System.out.println("Current Project : "+project);
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void hierarchy(int t) {
        for(int i=0;i<t;i++){
            System.out.print("\t");

        }
        System.out.println("- "+getName());
    }

    @Override
    public void print(boolean isHierarchy) {
        if(isHierarchy)
            hierarchy(0);
        else
            showDetails();
    }
}
