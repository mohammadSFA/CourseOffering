import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Schedule implements Serializable {
    private int term;
    private String name;
    private ArrayList<Section> sections;
    private static int scheduleCount;

    public Schedule() {}

    public Schedule(int term, ArrayList<Section> sections){
        this.term = term;this.sections = sections;
        scheduleCount++;
        name = "";
        
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


    // Method that saves the current schedule.
    public void saveSchedule() {
        String fileName;
        if (name.isEmpty()) fileName = "Schedule" + scheduleCount + ".dat";
        else fileName = name + ".dat";
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName); 
            ObjectOutputStream sch = new ObjectOutputStream(fileOutputStream)) {
            sch.writeObject(this);
        } catch (IOException e) {
            System.out.println(e);
                // TODO: handle exception
        }
    }


    // STATIC FILE TO READ SCHEDULE
    // // // Needs exception handling and error handling; and needs to verify whether file exists or not.
    public static Schedule readSchedule(File file) {
        // Empty schedule returned in case exception occurs during schedule retreival.
        Schedule savedSchedule = new Schedule();
        try (FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream sch = new ObjectInputStream(fileInputStream)) {
            savedSchedule = (Schedule) sch.readObject();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return savedSchedule;
    }
}


