import java.util.ArrayList;
import java.util.Arrays;
public class Course {
    private String code;
    private int creditH;
    private ArrayList<Course> preRequisite;
    private ArrayList<Course> coRequisite;

    // Constructor to add a course that has no pre or corequesites
    public Course(String code){
        this.code = code;
        //this.creditH = creditH;
    }

    // Constructor to add a course with co and/or prerequisites
    public Course(String code,int creditH, ArrayList<Course> preReq, ArrayList<Course> coReq ){
        this.coRequisite = (coReq);
        this.creditH = creditH;this.code = code;this.preRequisite = preReq;
    }
    public ArrayList<Course> getPreRequisite() {
        return preRequisite;
    }
    public ArrayList<Course> getCoRequisite() {
        return coRequisite;
    }
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Course) && (((Course)obj).code).equals(this.code);
    }
    public String getCode() {
        return code; //comment
    }

}
