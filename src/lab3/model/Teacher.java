package lab3.model;
import java.util.*;

import lab3.repository.ICrudRepository;

public class Teacher extends Person{
    private long id;
    private List<Course> courses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    public Teacher(){}

    public Teacher(long id,String firstName, String lastName, List<Course> courses) {
        super(firstName, lastName);
        this.courses = courses;
        this.id=id;
    }

    @Override
    public String toString() {
        String string="";
        for (Course course:courses)
            string+=course.getName()+", ";
        return "TEACHER :"+" teacher id - "+ id +" first name - "+ super.getFirstName()+", "+"last name - "+super.getLastName()+
                ", courses=" + string;
    }

    public List<Course> getCourseList() {
        return courses;
    }
    public void setCourseList(List<Course> courseList) {
        this.courses = courseList;
    }

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
