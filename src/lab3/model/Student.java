package lab3.model;
import java.util.*;

public class Student extends Person {
    private long studentId;
    private int totalCredits=0;
    private List<Course> enrolledCourse;

    public Student(){}

    public Student(long studentId, String firstName, String lastName, int totalCredits, List<Course> enrolledCourse) {
        super(firstName, lastName);
        this.studentId = studentId;
        this.totalCredits = totalCredits;
        this.enrolledCourse = enrolledCourse;
    }


    public long getId() {
        return studentId;
    }

    public void setId(long studentId) {
        this.studentId = studentId;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public List<Course> getEnrolledCourse() { return enrolledCourse; }

    public void setEnrolledCourse(List<Course> enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }

/*    @Override
    public String toString() {
        String string="";
        for (Course course:enrolledCourse)
            string+=course.getName()+", ";
        return "STUDENT : " +"first name - "+super.getFirstName()+", last name - " +super.getLastName()+", "+
                "studentId -" + studentId +
                ", totalCredits - " + totalCredits +
                ", enrolledCourse - " + string;
    }*/

    @Override
    public Object findOne(Long id) {
        return null;
    }

    @Override
    public Iterable findAll() {
        return null;
    }

    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public Object delete(Long id) {
        return null;
    }

    @Override
    public Object update(Object entity) {
        return null;
    }
}
