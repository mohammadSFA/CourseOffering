public class FinishedCourses extends Course{
    private Student student;
    private int term;
    private String grade;
    public FinishedCourses(String code,Student student,int term,String grade){
        super(code);
        this.student = student;
        this.term = term;
        this.grade = grade; 
    } 
    public int getTerm() {
        return term;
    }
    
}
