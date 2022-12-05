public class Schedule {
    int term;
    String name;
    Section [] sections;
    public Schedule(int term, Section[] sections){
        this.term = term;this.sections = sections;
    }
    public void setName(String name) {
        this.name = name;
    }
}
