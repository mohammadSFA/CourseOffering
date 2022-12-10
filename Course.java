import java.util.ArrayList;
import java.util.Arrays;
public class Course {
    // Instance Variables
    private String code;
    private String title;
    private int creditH;
    private Course[] preRequisite;

    // Constructor to add a course that has no pre or corequesites
    public Course(String code){
        this.code = code;
        //this.creditH = creditH;
    }

    // Constructor to add a course with co and/or prerequisites
    public Course(String code,int creditH, Course[] preReq ){
        this.creditH = creditH;this.code = code;this.preRequisite = preReq;
    }
    public Course[] getPreRequisite() {
        return preRequisite;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Course) ? (((Course)obj).code).equals(this.code) : false;
    }
    public String getCode() {
        return code; //comment
    }

    public String toString() {
        if (preRequisite != null) return code + "/" +  creditH + "/" + Arrays.toString(preRequisite);
        return code;
    }
}
