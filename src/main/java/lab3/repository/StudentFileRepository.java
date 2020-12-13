package lab3.repository;

import lab3.model.Course;
import lab3.model.Student;

import java.util.*;

public class StudentFileRepository implements ICrudRepository<Student>{

    public List<Student> studentList;


    public StudentFileRepository(){};
    public StudentFileRepository(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * @param id -the id of the Student to be returned id must not be null
     * @return the Student with the specified id or null - if there is no Student with the given id
     */

    @Override
    public Student findOne(Long id) {

        for (Student student:studentList){
            if(student.getId()==id)
                return student; }

        return null;
    }

    /**
     * @return all Students
     */

    @Override
    public Iterable<Student> findAll() {

        if (!studentList.isEmpty())
            return studentList;
        return null;
    }

    /**
     * @param Student entity must be not null
     * @return null- if the given Student is saved otherwise returns the Student (id already exists)
     */

    @Override
    public Student save(Student student) {

        if(findOne(student.getId())==null)
        {
            studentList.add(student);
            return student;
        }
        return null;
    }

    /**
     * removes the Student with the specified id
     *
     * @param id id must be not null
     * @return the removed Student or null if there is no Student with the given id
     */

    @Override
    public Student delete(Long id) {

        for (Student student:studentList)
            if(student.getId()==id)
            {
                studentList.remove(student);
                return student;
            }
        return null;
    }

    /**
     * @param Student entity must not be null
     * @return null - if the Student is updated, otherwise returns the Student- (e.g id does not exist).
     */

    @Override
    public Student update(Student student) {

        for(Student stud:studentList)
            if(stud.getId()==student.getId()){
                stud.setId(student.getId());
                stud.setFirstName(student.getFirstName());
                stud.setLastName(student.getLastName());
                stud.setTotalCredits(student.getTotalCredits());
                stud.setEnrolledCourse(student.getEnrolledCourse());
                return null;
            }
        return student;
    }
}
