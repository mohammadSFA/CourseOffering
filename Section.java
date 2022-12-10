import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

public class Section {
    private Course course;
    private String sectionNum;
    private int term;
    private int crn;
    private String location;
    private String instructor;
    private String days;
    private String time;

    // Single variable constructor
    public Section(Course course){
        this.course = course;
    }

    // Constructor with all variables
    public Section(Course course, int crn, String sectionNum, String location, String days, String time, String instructor){
        this.course = course; this.crn = crn; this.sectionNum= sectionNum; this.location = location;
        this.time = time; this.days = days; this.instructor = instructor;
    }
    @Override
    public String toString() {
        return course.getCode()+"-"+sectionNum+"/"+ crn +"/"+course.getTitle()+"/"+instructor+"/"+location+"/"+ days +"/"+time;
    }

    public String getTime() {
        return time;
    }

    public double getStartTime(){
        double startTime = Double.parseDouble(time.substring(0,3))+Double.parseDouble(time.substring(3,5))/60;
        return startTime;
    }
    public double getEndTime(){
        double endTime = Double.parseDouble(time.substring(6,8))+Double.parseDouble(time.substring(8))/60;
        return endTime;
    }

    public boolean isConflict(Section other) {
                boolean dayConflict= false;
        boolean timeConflict= false;
        for (char i : days.toCharArray())
            for(char j : other.days.toCharArray())
                if (i==j) dayConflict = true;
    
        timeConflict = (other.getEndTime() >= getStartTime())&&(other.getStartTime() < getEndTime());
        return dayConflict && timeConflict;
    }

}