import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<CrewInterface> crews=new ArrayList<>();
        ArrayList<ImposterInterface> imposters=new ArrayList<>();

        crews.add(new CrewMember("Abul"));
        crews.add(new CrewMember("Babul"));
        crews.add(new CrewMember("Habul"));

        ImposterMember xOne=new ImposterMember("xOne");
        ImposterMember xTwo=new ImposterMember("xTwo");

        crews.add(new AdaptImposter(xOne));
        crews.add(new AdaptImposter(xTwo));

        imposters.add(xOne);
        imposters.add(xTwo);

        System.out.println("Using imposters' methods : ");
        System.out.println("--------------------------------------");
        for(ImposterInterface i: imposters){
            i.doPoison(false);
            i.doDamageSpaceShip(false);
        }

        System.out.println();
        System.out.println("After Adaption, Using Adapters Methods: ");
        System.out.println("-----------------------------------------");
        for(CrewInterface c : crews){
            c.doStudy();
            c.doMaintenance();
        }
    }
}