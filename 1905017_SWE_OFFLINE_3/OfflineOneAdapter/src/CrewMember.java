public class CrewMember implements CrewInterface{
    String name;
    public CrewMember(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    @Override
    public void doStudy() {
        System.out.println("Crew "+this.name+" is studying interstellar objects.....");
    }

    @Override
    public void doMaintenance() {
        System.out.println("Crew "+this.name+" is doing basic maintenance task of the spaceship.....");
    }

}
