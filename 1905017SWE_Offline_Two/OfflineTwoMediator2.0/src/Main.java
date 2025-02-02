import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);



        Mediator mediator=new Mediator();
        Examiner examiner=new Examiner(mediator);
        mediator.setExaminer(examiner);

        int numberOfStudent=10;
        List<Student> studentList=new ArrayList<>();
        for(int i=0;i<numberOfStudent;i++){
            studentList.add(new Student(i,mediator));
        }
        mediator.setStudentsList(studentList);

        ExamBundle bundle=new ExamBundle();

        for(int i=0;i<numberOfStudent;i++){
            bundle.examScriptList.add(new ExamScript(i));
        }

        examiner.checkAndSetMarks(bundle);
        /*System.out.println("Seeing if students got their marks");
        for(int i=0;i<numberOfStudent;i++){
            System.out.println(studentList.get(i).getId()+" "+studentList.get(i).getMark()+" "+studentList.get(i).getExamScript().getMarks());
        }*/

        while(true){
            System.out.println("Please Enter which student want re-examine:");
            int option=scanner.nextInt();
            studentList.get(option).requestReExamine();
        }


    }
}
