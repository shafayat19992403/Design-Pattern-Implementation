import java.util.List;
import java.util.Random;

public class Examiner implements Participents{
    private Mediator mediator;

    public Examiner(Mediator mediator){
        this.mediator=mediator;
    }

    public Mediator getMediator(){
        return mediator;
    }

    @Override
    public void receive(ExamBundle bundle){
        System.out.println("Received and initiating Re-examine "+bundle.examScriptList.get(0).getStudentIdOfExamScript());
        if(bundle.examScriptList.get(0).getMarks()==bundle.markList.get(0)){
            bundle.examScriptList.get(0).setReExamineStatus(2);
        }
        else if(bundle.examScriptList.get(0).getMarks()>bundle.markList.get(0)){
            bundle.markList.set(0,bundle.examScriptList.get(0).getMarks());
            bundle.examScriptList.get(0).setReExamineStatus(3);
        }
        else if(bundle.examScriptList.get(0).getMarks()<bundle.markList.get(0)){
            bundle.markList.set(0,bundle.examScriptList.get(0).getMarks());
            bundle.examScriptList.get(0).setReExamineStatus(4);
        }
        else{

        }
        mediator.send(this,bundle);
        System.out.println("Done Re-Examine and Sent to mediator ");
    }

    public void checkAndSetMarks(ExamBundle bundle){
        Random random=new Random();
        for(ExamScript examScriptSingle : bundle.examScriptList){
            int randomMark=random.nextInt(51)+50;
            examScriptSingle.setMarks(randomMark);
        }

        int index=random.nextInt(bundle.examScriptList.size());
        for(int i=0;i<bundle.examScriptList.size();i++){
            if(i==index){
                bundle.markList.add(bundle.examScriptList.get(i).getMarks()-1);
                continue;
            }

            int hudaiNumber= random.nextInt(10);
            if(hudaiNumber%2==0)
            {
                int jogKorboNaki=random.nextInt()%2;
                if(jogKorboNaki==0)
                    bundle.markList.add(Integer.valueOf(bundle.examScriptList.get(i).getMarks()-2));
                else
                    bundle.markList.add(Integer.valueOf(bundle.examScriptList.get(i).getMarks()+2));
            }
            else
                bundle.markList.add(Integer.valueOf(bundle.examScriptList.get(i).getMarks()));

        }
        System.out.println("Examiner has completed putting marks in the scripts and in the marklist");
        System.out.println("Examiner is sending the scriptlist and marklist to examController");
        /*for(int i=0;i<bundle.examScriptList.size();i++){
            System.out.println(bundle.examScriptList.get(i).getStudentIdOfExamScript()+" got "+bundle.examScriptList.get(i).getMarks()+" marklist: "+bundle.markList.get(i));
        }*/
        mediator.send(this,bundle);
    }

}
