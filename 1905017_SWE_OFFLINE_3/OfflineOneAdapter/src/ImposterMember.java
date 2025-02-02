public class ImposterMember implements ImposterInterface{
    String name;
    public ImposterMember(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    @Override
    public void doPoison(boolean isAdapted) {
        if(isAdapted)
            System.out.println("Imposter "+this.getName()+" is studying interstellar objects....!!!");
        else
            System.out.println("Imposter "+this.name+" is poisoning the crew-mates.....");
    }

    @Override
    public void doDamageSpaceShip(boolean isAdapted) {
        if(isAdapted)
            System.out.println("Imposter "+this.getName()+" is doing basic maintenance task of the spaceship...!!!");
        else
            System.out.println("Imposter "+this.name+" is damaging the spaceship.....");
    }
}
