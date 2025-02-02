public class ExamScript {
    private int studentID;
    private int marks;
    private int reExamineStatus;

    public ExamScript(int id){
        studentID=id;
        //this.marks=marks;
        reExamineStatus=1;
    }

    public void setMarks(int marks){
        this.marks=marks;
    }
    public int getMarks(){
        return marks;
    }
    public int getStudentIdOfExamScript(){
        return studentID;
    }
    public int getReExamineStatus(){
        return reExamineStatus;
    }
    public void setReExamineStatus(int s){
        reExamineStatus=s;
    }
    public String toString(){
        return "Student ID: "+studentID+"   Script Marks: "+marks;
    }
}
