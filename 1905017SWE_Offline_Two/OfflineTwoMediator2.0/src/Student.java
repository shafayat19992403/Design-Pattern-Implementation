public class Student implements Participents{
    private int id;
    private Mediator mediator;
    private ExamScript examScript;
    private int mark;
    public Student(int id,Mediator mediator){
        this.id=id;
        this.mediator=mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public int getId(){
        return id;
    }

    public int getMark() {
        return mark;
    }

    public ExamScript getExamScript() {
        return examScript;
    }

    @Override
    public void receive(ExamBundle bundle){
        examScript=bundle.examScriptList.get(0);
        mark=bundle.markList.get(0);
    }

    public void requestReExamine(){
        if(examScript==null){
            System.out.println("didnt receive any scripts");
        }
        ExamBundle bundle=new ExamBundle();
        bundle.examScriptList.add(examScript);
        bundle.markList.add(mark);
        mediator.send(this,bundle);
    }
}
