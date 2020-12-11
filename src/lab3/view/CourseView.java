package lab3.view;

import lab3.model.Person;
import lab3.model.Student;

import java.util.List;

public class CourseView {
    public void printCourseView(long id,String name, Person teacher, int maxEnrollment, List<Student> studentsEnrolled, int credits){
        System.out.println("Course: ");
        System.out.println("Id: "+id);
        System.out.println("Name: "+name);
        System.out.println("Teacher: "+teacher);
        System.out.println("Maximum enrollment number: "+maxEnrollment);
        System.out.println("Students enrolled: "+studentsEnrolled);
        System.out.println("Number of credits: "+credits);
    }
}
