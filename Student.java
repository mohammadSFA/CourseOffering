import java.util.ArrayList;
public class Student {
    private ArrayList<FinishedCourse> finishedCourses = new ArrayList<FinishedCourse>();
    public void addFinishedCourse(FinishedCourse c){
        finishedCourses.add(c);
    }
    public boolean took(Course course){
        return finishedCourses.contains(course);
    }

    public boolean tookPreRequisite(Course course,int term){
        for (Course c : course.getPreRequisite())
            if (!finishedCourses.contains(c))
                return false;
            else if(((FinishedCourse)c).getTerm()>=term)
                return false;
        return true;  
    }
    // public boolean tookCoRequisite(Course course, int term){
    //     for (Course c : course.getCoRequisite())
    //         if (!finishedCourses.contains(c))
    //             return false;
    //         else if(((FinishedCourse)c).getTerm()>term)
    //             return false;
    //     return true;  
    // }
    // public boolean canAdd(Course course,int term){
    //     return (!took(course))&&tookCoRequisite(course, term)&&tookCoRequisite(course, term);
    // }



}
