public class FinishedCourse extends Course{
    private int term;
    private String grade;
    public FinishedCourse(String code,int term,String grade){
        super(code);
        this.term = term;
        this.grade = grade; 
    } 
    public int getTerm() {
        return term;
    }
    
    public String toString() {
        return super.getCode() + "/" + grade + "/" + term;
    }
}
