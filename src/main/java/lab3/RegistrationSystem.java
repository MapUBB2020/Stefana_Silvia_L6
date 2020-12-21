package lab3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lab3.model.Course;
import lab3.model.Student;
import lab3.model.Teacher;
import lab3.repository.CourseFileRepository;
import lab3.repository.TeacherFileRepository;

import java.util.*;
import java.util.stream.Collectors;


public class RegistrationSystem {

    CourseFileRepository courseFileRepository;
    TeacherFileRepository teacherFileRepository;

    /**
     * constructor
     * @param courseFileRepository
     */
    public RegistrationSystem(CourseFileRepository courseFileRepository,TeacherFileRepository teacherFileRepository) {
        this.courseFileRepository = courseFileRepository;
        this.teacherFileRepository=teacherFileRepository;
    }

    /**
     * @param id of the course the student wants to register to
     * @param student who wants to register
     * @return true if he can register, false otherwise
     * first we verify if the course exists
     * then if there are still available places
     * then we check the credits to be under 30
     * we add the student in the list from Course with all the students from a course - studentsEnrolled
     * we add the course in courseList from CourseRepo
     * we update the students totalCredit after he registered successfully for a new course
     */

    public String register(long id, Student student) {

        if (courseFileRepository.findOne(id) == null) {
            return "Acest curs nu exista! Va rugam selectati altul!";
        }
        for(Student stud:courseFileRepository.findOne(id).getStudentsEnrolled()) {
            if (student.getId() == stud.getId())
                return "Esti deja inscris la acest curs!";
        }
        if(courseFileRepository.findOne(id).getMaxEnrollment()<= courseFileRepository.findOne(id).getStudentsEnrolled().size()){
            return "Cursul selectat nu mai are locuri libere!";
        }
        if ((student.getTotalCredits() + courseFileRepository.findOne(id).getCredits()) > 30){
            return "Aveti deja 30 credite!";
        }

        courseFileRepository.findOne(id).getStudentsEnrolled().add(student);
        student.getEnrolledCourse().add(courseFileRepository.findOne(id));
        student.setTotalCredits(student.getTotalCredits()+ courseFileRepository.findOne(id).getCredits());
        return "Te-ai inregistrat cu succes!";
    }


    /**
     * @return a list named available that contains all the courses with free places
     */

    public String retrieveCoursesWithFreePlaces(){

        List<String> available= new ArrayList<String>();
        for(Course course: courseFileRepository.getCourseList())
        {
            int free=course.getMaxEnrollment()-course.getStudentsEnrolled().size();
            if(free>0)
            available.add(course.getName()+" are "+free+" locuri libere :)");
        }

        return available.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining("\n", "", " "));
    }

    /**
     * @param course
     * @return all students enrolled in the course from param
     */
    public List<Student> retrieveStudentsEnrolledForACourse(Course course){
        return  course.getStudentsEnrolled();
    }

    /**
     * @param id of the course to be deleted
     * @param teacher
     * @return true if deleted else false
     * if the length of the courseList has changed after teacher has deleted one of his courses, true else false
     */
    public boolean deleteCourse(long id,Teacher teacher){
        int l1=teacher.getCourseList().size();
        teacher.getCourses().remove(courseFileRepository.findOne(id));
        int l2=teacher.getCourseList().size();
        return l1 > l2;
    }

    /**
     * @return a list with all courses
     */
    public String getAllCourses(){

        List<String> allCourses= new ArrayList<String>();
        for(Course course: courseFileRepository.getCourseList())
                allCourses.add("id: "+course.getId()+" - "+course.getName());

        return allCourses.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n\t", "Cursurile existente sunt:\n\t", " "));

    }

    /**
     * @param id course
     * @param teacher
     * @param newCredit for course
     * @return the course with changed credits
     */
    public Course changeCredits(long id, Teacher teacher, int newCredit) {
        for (Course course : courseFileRepository.getCourseList())
            if (id == course.getId() && course.getTeacher()==teacher){
                courseFileRepository.findOne(id).setCredits(newCredit);
                return courseFileRepository.findOne(id);
            }
        return null;
    }

    /**
     * @return list "sortet" which has all courses ordered by the higher credits
     */
    public List<Course> sortCoursesByCredits(){

        List<Course> sorted=courseFileRepository.courseList;
        for(int i=0; i<sorted.size()-1;i++)
            for(int j=1; j<sorted.size();j++)
                if(sorted.get(i).getCredits()<sorted.get(j).getCredits())
                {
                    Collections.swap(sorted, i, j);
                }
        return sorted;
    }

    /**
     * @return list "filtered" which contains courses with minimum 2 student enrolled
     */
    public List<Course> filterCourseByEnrolledStudents(){
        List<Course> filtered=new ArrayList<>();
        for(Course course:courseFileRepository.courseList){
            if(course.getStudentsEnrolled().size()>1)
                filtered.add(course);
        }
        return filtered;
    }
    public boolean validateTeacherId(long id){
        for(Teacher teacher:teacherFileRepository.teacherList)
            if(teacherFileRepository.findOne(id)==teacher)
                return true;

        return false;

    }

}
