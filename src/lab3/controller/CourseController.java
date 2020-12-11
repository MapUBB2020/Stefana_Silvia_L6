package lab3.controller;

import lab3.model.Course;
import lab3.model.Person;
import lab3.model.Student;
import lab3.view.CourseView;

import java.util.List;

public class CourseController{
    private Course course;
    private CourseView view;

    public CourseController(Course course, CourseView view){
        this.course=course;
        this.view=view;
    }

    public void setCourseId(long id) {
        course.setId(id);
    }
    public long getCourseId() { return course.getId(); }

    public void setCourseName(String name) {
        course.setName(name);
    }
    public String getCourseName() { return course.getName(); }


    public void setCourseTeacher(Person teacher) {
        course.setTeacher(teacher);
    }
    public Person getCourseTeacher() {
        return course.getTeacher();
    }


    public void setCourseMaxEnrollment(int maxEnrollment) {
        course.setMaxEnrollment(maxEnrollment);
    }
    public int getCourseMaxEnrollment() {
        return course.getMaxEnrollment();
    }

    public void setCourseCredits(int credits) {
        course.setCredits(credits);
    }
    public int getCourseCredits() {
        return course.getCredits();
    }

    public void setCourseStudentsEnrolled(List<Student> studentsEnrolled) { course.setStudentsEnrolled(studentsEnrolled); }
    public List<Student> getCourseStudentsEnrolled() { return course.getStudentsEnrolled(); }


    public void updateView(){
        view.printCourseView(course.getId(),course.getName(),course.getTeacher(),course.getMaxEnrollment(),course.getStudentsEnrolled(),course.getCredits());
    }
}
