public class AdaptImposter implements CrewInterface{
    ImposterMember imposterMember;
    public AdaptImposter(ImposterMember imposterMember){
        this.imposterMember=imposterMember;
    }
    @Override
    public void doStudy() {

        this.imposterMember.doPoison(true);
    }

    @Override
    public void doMaintenance() {
        this.imposterMember.doDamageSpaceShip(true);
    }
}
