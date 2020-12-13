package lab3.repository;

import lab3.model.Course;
import lab3.model.Student;
import lab3.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class CourseFileRepository implements ICrudRepository<Course> {
    public List<Course> courseList;

    public CourseFileRepository(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    /**
     * @param id -the id of the Course to be returned id must not be null
     * @return the Course with the specified id or null - if there is no entity with the given id
     */
    @Override
    public Course findOne(Long id) {
        for (Course course:courseList)
            if(course.getId()==id)
                return course;
        return null;
    }


    /**
     * @return all Courses
     */

    @Override
    public Iterable<Course> findAll() {
        if (!courseList.isEmpty())
            return courseList;
        return null;
    }

    /**
     * @param Course entity must be not null
     * @return null- if the given Course is saved otherwise returns the Course (id already exists)
     */

    @Override
    public Course save(Course course) {
        if(findOne(course.getId())==null)
        {
            courseList.add(course);

            return course;
        }
        return null;
    }

    /**
     * removes the Course with the specified id
     *
     * @param id id must be not null
     * @return the removed Course or null if there is no Course with the given id
     */

    @Override
    public Course delete(Long id) {
        for (Course course:courseList)
            if(course.getId()==id)  {
                courseList.remove(course);
                return course;
            }
        return null;
    }

    /**
     * @param Course entity must not be null
     * @return null - if the Course is updated, otherwise returns the Course- (e.g id does not exist).
     */
    @Override
    public Course update(Course course) {

        for(Course curs:courseList)
            if(curs.getId()==course.getId()){
                curs.setId(course.getId());
                curs.setName(course.getName());
                curs.setTeacher(course.getTeacher());
                curs.setMaxEnrollment(course.getMaxEnrollment());
                curs.setStudentsEnrolled(course.getStudentsEnrolled());
                curs.setCredits(course.getCredits());
                return null;
            }
        return course;
    }
}

