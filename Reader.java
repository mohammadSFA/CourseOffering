import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public static void main(String[] args) {

    ArrayList<Course> addableC = addableCourses(finishedCourses(), degreeCourses());
    try {
        addableSections(addableC);
    } catch (IOException e) {
        System.out.println(e);
    }
    }


    // Taking the student's finished courses as an ArrayList, and returning it.
    public static ArrayList<FinishedCourse> finishedCourses() {
        ArrayList<FinishedCourse> finished = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File("MohammadAlsharif.csv"))) {
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {
                String[] course = fileScanner.nextLine().split(",");
                finished.add(new FinishedCourse(course[0], Integer.parseInt(course[1]), course[2]));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return finished;
    }

    // Returns the courses in the degree plan as an ArrayList.
    public static ArrayList<Course> degreeCourses() {
        ArrayList<Course> degreeCourses = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File("COEPlan.csv"))) {
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {
                String[] course = fileScanner.nextLine().split(",");
                String[] preReqNames = (course[2].equals("-")) ? new String[0] : course[2].split(";");
                Course[] preReq = new Course[preReqNames.length];
                for (int i = 0; i<preReq.length; i++) {preReq[i] = new Course(preReqNames[i]);}
                degreeCourses.add(new Course(course[0], Integer.parseInt(course[1]), preReq));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return degreeCourses;
    }

    // Returns the courses that the student can take for the next semester.
    public static ArrayList<Course> addableCourses(ArrayList<FinishedCourse> finished, ArrayList<Course> plan) {
        ArrayList<Course> canAdd = new ArrayList<>();
        for (Course p : plan) {
            boolean finishedPreReqs = true;
            for (Course c : p.getPreRequisite()) {
                if (!finished.contains(new Course(c.getCode()))) finishedPreReqs = false;
            }

            if (!finished.contains(new Course(p.getCode())) 
            && (p.getPreRequisite() == null || finishedPreReqs)) canAdd.add(p);
        }

        System.out.println(canAdd);
        return canAdd;
    }

    // Returns ArrayList of sections that can be added.
    public static ArrayList<Section> addableSections(ArrayList<Course> addableCourses) throws IOException {
        ArrayList<Section> sections = new ArrayList<>();
        System.out.println(addableCourses);
            for (Course c : addableCourses) {
                int sectionCounter = 0;
                try (BufferedReader br = new BufferedReader(new FileReader("CourseOffering.csv"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                    
                    // Checks that section from csv file is of the given course c, and is not a female section.
                    if(line.substring(0, 7).equals(c.getCode()) && line.charAt(8) != 'F') {
                        String[] secString = line.split(",");
                        System.out.println(Arrays.toString(secString));

                        // Setting the title of the course (only does so when reaching the first section)
                        sectionCounter++;
                        if (sectionCounter == 1) c.setTitle(secString[3]);

                        // Adding the new section
                        sections.add(new Section(c, Integer.parseInt(secString[2]), 
                        secString[0].substring(9), secString[7], secString[5], secString[6], secString[4]));
                    }
                    }
                }
            }
        return sections;
    }
}
