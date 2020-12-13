package lab3.controller;

import lab3.model.Course;
import lab3.model.Student;
import lab3.repository.StudentFileRepository;
import lab3.view.StudentView;

import java.util.List;

public class StudentFileController extends StudentFileRepository {
    private Student stud;
    private StudentView view;

    //super
    public StudentFileController(Student stud, StudentView view){
        this.stud=stud;
        this.view=view;
    }

    public void setStudentId(long studentid){
        stud.setId(studentid);
    }
    public long getStudentId(){
        return stud.getId();
    }


    public void setStudentFirstName(String firstName){
        stud.setFirstName(firstName);
    }
    public String getStudentFirstName(){
        return stud.getFirstName();
    }


    public void setStudentLastName(String lastName){
        stud.setLastName(lastName);
    }
    public String getStudentLastName(){
        return stud.getLastName();
    }


    public void setStudentTotalCredits(int totalCredits){
        stud.setTotalCredits(totalCredits);
    }
    public int getStudentTotalCredits(){
        return stud.getTotalCredits();
    }


    public void setStudentsEnrolledCourse(List<Course> enrolledCourse) {
        stud.setEnrolledCourse(enrolledCourse);
    }
    public List<Course> getStudentEnrolledCourse() {
        return stud.getEnrolledCourse();
    }


    public void updateView(){
        view.printStudentDetails(stud.getId(),stud.getFirstName(),stud.getLastName(),stud.getTotalCredits());
    }

}
