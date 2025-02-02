import java.util.List;
import java.util.Random;

public class Mediator implements MediatorInterface{
    private Examiner examiner;
    private List<Student> StudentsList;
    private List<ExamScript> examScriptList;
    private List<Integer> markList;

    public void setExaminer(Examiner examiner){
        this.examiner=examiner;
    }
    public void setStudentsList(List<Student> listOfStudent){
        StudentsList=listOfStudent;
    }

    public void setExamScriptList(List<ExamScript> examScriptList) {
        this.examScriptList = examScriptList;
    }

    public void setMarkList(List<Integer> markList) {
        this.markList = markList;
    }

    @Override
    public void send(Participents participents,ExamBundle bundle){
        if(participents instanceof Examiner && bundle.examScriptList.size()>1){

            for(int i=0;i<bundle.examScriptList.size();i++){
                System.out.println(bundle.examScriptList.get(i).getStudentIdOfExamScript()+" got "+bundle.examScriptList.get(i).getMarks()+" marklist: "+bundle.markList.get(i));
            }

            for(int i=0;i<bundle.examScriptList.size();i++){
                Random random=new Random();
                boolean isFixable;

                if(random.nextInt()%2==1) isFixable=true;
                else isFixable=false;

                if(bundle.examScriptList.get(i).getMarks() == bundle.markList.get(i)){
                    continue;
                }
                else{
                    if(isFixable){
                        bundle.markList.set(i,bundle.examScriptList.get(i).getMarks());
                    }
                    else{
                        continue;
                    }
                }
            }
            System.out.println("After Scrutiny");
            for(int i=0;i<bundle.examScriptList.size();i++){
                System.out.println(bundle.examScriptList.get(i).getStudentIdOfExamScript()+" got "+bundle.examScriptList.get(i).getMarks()+" marklist: "+bundle.markList.get(i));
            }

            System.out.println("Sending all the scripts to the students...");
            for(int i=0;i<bundle.examScriptList.size();i++){
                ExamBundle temp=new ExamBundle();
                temp.examScriptList.add(bundle.examScriptList.get(i));
                temp.markList.add(bundle.markList.get(i));
                StudentsList.get(i).receive(temp);
            }
            System.out.println("Sent all to the students....");

            /*saving the scripts and markList*/
            setExamScriptList(bundle.examScriptList);
            setMarkList(bundle.markList);
        }
        else if(participents instanceof Examiner && bundle.examScriptList.size()==1){
            if(bundle.examScriptList.get(0).getReExamineStatus()==2){
                System.out.println("No Change in Mark");
            }else if(bundle.examScriptList.get(0).getReExamineStatus()==3){
                markList.set(bundle.examScriptList.get(0).getStudentIdOfExamScript(),bundle.markList.get(0));
                System.out.println("Marks has been increased");
            }else if(bundle.examScriptList.get(0).getReExamineStatus()==4){
                markList.set(bundle.examScriptList.get(0).getStudentIdOfExamScript(),bundle.markList.get(0));
                System.out.println("Marks has been decreased");
            }
            StudentsList.get(bundle.examScriptList.get(0).getStudentIdOfExamScript()).receive(bundle);

            System.out.println("After Scrutiny");
            if(examScriptList==null || markList==null){
                System.out.println("Result Hasn't been published yet");
            }else{
                for(int i=0;i<examScriptList.size();i++){
                    System.out.println("Student "+i+" got "+examScriptList.get(i).getMarks()+" marklist "+markList.get(i));
                }
            }
        }
        else if(participents instanceof Student){
            System.out.println("Re-Examining "+((Student) participents).getId());
            examiner.receive(bundle);
        }


    }
}
