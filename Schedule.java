import java.io.File;
import java.util.ArrayList;

public class Schedule {
    private int term;
    private String name;
    private ArrayList<Section> sections;
    private static int scheduleCount;
    public Schedule(int term, ArrayList<Section> sections){
        this.term = term;this.sections = sections;
        scheduleCount++;
        
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addSection(Section s) {
        sections.add(s);
    }

    public void removeSection(Section s) {
        sections.remove(s);
    }

    public void saveSchedule() {
        String fileName;
        if (name == null) fileName = "Schedule" + scheduleCount + ".dat";
        else 
        try () {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}


