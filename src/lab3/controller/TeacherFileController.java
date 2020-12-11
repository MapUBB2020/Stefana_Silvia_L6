package lab3.controller;

import lab3.model.Course;
import lab3.model.Teacher;
import lab3.repository.TeacherFileRepository;
import lab3.view.TeacherView;

import java.util.List;

public class TeacherFileController extends TeacherFileRepository {
    private Teacher teacher;
    private TeacherView view;

    public TeacherFileController(Teacher teacher, TeacherView view){
        this.teacher=teacher;
        this.view=view;
    }

    public void setTeacherId(long teacherid){ teacher.setId(teacherid); }
    public long getTeacherId(){ return teacher.getId(); }

    public void setTeacherFirstName(String firstName){
        teacher.setFirstName(firstName);
    }
    public String getTeacherFirstName(){
        return teacher.getFirstName();
    }


    public void setTeacherLastName(String lastName){
        teacher.setLastName(lastName);
    }
    public String getTeacherLastName(){
        return teacher.getLastName();
    }


    public void setTeacherCourseList(List<Course> courseList) { teacher.setCourseList(courseList); }
    public List<Course> getTeacherCourseList() {
        return teacher.getCourseList();
    }


    public void updateView(){
        view.printTeacherDetails(teacher.getId(),teacher.getFirstName(),teacher.getLastName(),teacher.getCourseList());
    }
}
