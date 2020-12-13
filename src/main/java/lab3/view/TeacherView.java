package lab3.view;

import lab3.model.Course;

import java.util.List;

public class TeacherView {
    public void printTeacherDetails(long id,String prenume, String nume, List<Course> courseList){
        System.out.println("Id: "+id);
        System.out.println("Teacher: ");
        System.out.println("First name: "+prenume);
        System.out.println("Last name: "+nume);
        System.out.println("Courses list: "+courseList);
    }
}
