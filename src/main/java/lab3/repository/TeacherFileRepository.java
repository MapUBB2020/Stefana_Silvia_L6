package lab3.repository;

import lab3.model.Teacher;

import java.util.List;

public class TeacherFileRepository implements ICrudRepository<Teacher>{

    public List<Teacher> teacherList;

    public TeacherFileRepository(){};

    public TeacherFileRepository(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    /**
     * @param id -the id of the Teacher to be returned id must not be null
     * @return the Teacher with the specified id or null - if there is no Teacher with the given id
     */

    @Override
    public Teacher findOne(Long id) {

        for (Teacher teacher:teacherList)
            if(teacher.getId()==id)
                return teacher;
        return null;
    }

    /**
     * @return all Teachers
     */

    @Override
    public Iterable<Teacher> findAll() {
        if (!teacherList.isEmpty())
            return teacherList;
        return null;
    }

    /**
     * @param Teacher entity must be not null
     * @return null- if the given Teacher is saved otherwise returns the Teacher (id already exists)
     */

    @Override
    public Teacher save(Teacher teacher) {

        if(findOne(teacher.getId())==null)
        {
            teacherList.add(teacher);
            return teacher;
        }
        return null;
    }

    /**
     * removes the Teacher with the specified id
     *
     * @param id id must be not null
     * @return the removed Teacher or null if there is no Teacher with the given id
     */

    @Override
    public Teacher delete(Long id) {

        for (Teacher teacher:teacherList)
            if(teacher.getId()==id)  {
                teacherList.remove(teacher);
                return teacher;
            }
        return null;
    }

    /**
     * @param Teacher entity must not be null
     * @return null - if the Teacher is updated, otherwise returns the Teacher- (e.g id does not exist).
     */

    @Override
    public Teacher update(Teacher teacher) {

        for(Teacher teach:teacherList) {
            if (teach.getId() == teacher.getId()) {
                teach.setId(teacher.getId());
                teach.setFirstName(teacher.getFirstName());
                teach.setLastName(teacher.getLastName());
                teach.setCourses(teacher.getCourses());
                return null;
            }
        }
        return teacher;
    }



}
