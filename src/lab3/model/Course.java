package lab3.model;
import java.util.*;

public class Course {
    private long id;
    private String name;
    private Person teacher;
    private int maxEnrollment;
    private List<Student> studentsEnrolled;
    private int credits;

    public Course(){}

    public Course(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }


    /**
     * (constructor)
     * @param id course
     * @param name course
     * @param maxEnrollment max number of students that can join a course
     * @param credits the number of credits from a course
     * @param studentsEnrolled list with all the students from a course
     */
    public Course(long id, String name, int maxEnrollment, int credits,List<Student> studentsEnrolled) {
        this.id=id;
        this.name = name;
        this.maxEnrollment = maxEnrollment;
        this.studentsEnrolled = studentsEnrolled;
        this.credits = credits;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Person getTeacher() {
        return teacher;
    }


    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }


    public int getMaxEnrollment() {
        return maxEnrollment;
    }


    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }


    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }


    public void setStudentsEnrolled(List<Student> studentsEnrolled) { this.studentsEnrolled = studentsEnrolled; }


    public int getCredits() {
        return credits;
    }


    public void setCredits(int credits) {
        this.credits = credits;
    }


    @Override
    public String toString() {
        return "Course" +
                "id= "+id+", "+
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                ", maxEnrollment=" + maxEnrollment +
                ", studentsEnrollment=" + studentsEnrolled +
                ", credits=" + credits
                ;
    }

}

