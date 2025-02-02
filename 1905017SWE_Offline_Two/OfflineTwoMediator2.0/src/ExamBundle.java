import java.util.ArrayList;
import java.util.List;

public class ExamBundle {
    public List<ExamScript> examScriptList;
    public List<Integer> markList;
    public ExamBundle(){
        examScriptList=new ArrayList<>();
        markList=new ArrayList<>();
    }
}
