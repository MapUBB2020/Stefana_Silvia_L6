
package lab3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import lab3.model.Course;
import lab3.model.Student;
import lab3.model.Teacher;
import lab3.repository.CourseFileRepository;
import lab3.repository.StudentFileRepository;
import lab3.repository.TeacherFileRepository;

public class JsonReader {


    public static void read() throws IOException {
        List<Course> courses = new ArrayList<Course>();
        CourseFileRepository cr = new CourseFileRepository(courses);
        /**
         * exception for file not found
         * */
        try {
            /**
             * reads from course.json and set the attributes for the obj course
             * and then add the obj course in courseList from CourseFileRepository
             * */
            Reader reader = new BufferedReader(new FileReader("course.json"));

            ObjectMapper om = new ObjectMapper();
            JsonNode parser = om.readTree(reader);

            for (JsonNode pm : parser.path("courseList")) {
                Course course = new Course();

                course.setId(pm.path("id").asInt());
                course.setName(pm.path("name").asText());
                course.setMaxEnrollment(pm.path("maxEnrollment").asInt());
                course.setCredits(pm.path("credits").asInt());
                cr.getCourseList().add(course);
            }
            reader.close();

        } catch(FileNotFoundException e)
        {
            System.out.println("Error file not found");
            System.exit(0);
        }

        List<Student> students = new ArrayList<Student>();
        StudentFileRepository sr=new StudentFileRepository(students);

        try {
            /**
             * reads from student.json and set the attributes for the obj student
             * and then add the obj course in studentList from StudentFileRepository
             * */
            Reader reader1 = new BufferedReader(new FileReader("student.json"));

            ObjectMapper om1 = new ObjectMapper();
            JsonNode parser1 = om1.readTree(reader1);


            for (JsonNode pm : parser1.path("studentList")) {
                List<Course> enrolledCourse = new ArrayList<Course>();
                Student student = new Student();

                student.setId(pm.path("id").asInt());
                student.setFirstName(pm.path("firstName").asText());
                student.setLastName(pm.path("lastName").asText());
                student.setTotalCredits(pm.path("totalCredits").asInt());
                sr.getStudentList().add(student);
                /**
                 * add courses in enrolledCourse for each student
                 * */
                if (student.getId() == 1) {
                    enrolledCourse.add(cr.findOne((long) 1));
                    enrolledCourse.add(cr.findOne((long) 3));
                } else if (student.getId() == 2) {
                    enrolledCourse.add(cr.findOne((long) 1));
                    enrolledCourse.add(cr.findOne((long) 2));
                } else if (student.getId() == 3)
                    enrolledCourse.add(cr.findOne((long) 2));

                student.setEnrolledCourse(enrolledCourse);

            }
            reader1.close();

        } catch(FileNotFoundException e)
        {
            System.out.println("Error file not found");
            System.exit(0);
        }


        List<Teacher> teachers = new ArrayList<Teacher>();
        TeacherFileRepository tr=new TeacherFileRepository(teachers);
        try {

            /**
             * reads from teacher.json and set the attributes for the obj teacher
             * and then add the obj course in studentList from StudentFileRepository
             * */
            Reader reader2 = new BufferedReader(new FileReader("teacher.json"));

            ObjectMapper om2 = new ObjectMapper();
            JsonNode parser2 = om2.readTree(reader2);


            for (JsonNode pm : parser2.path("TeacherList")) {
                List<Course> coursesT = new ArrayList<>();
                Teacher teacher = new Teacher();

                teacher.setId(pm.path("id").asInt());
                teacher.setFirstName(pm.path("firstName").asText());
                teacher.setLastName(pm.path("lastName").asText());
                tr.getTeacherList().add(teacher);
                /**
                 * set a teacher for every course
                 * */
                if (teacher.getId() == 1) {
                    coursesT.add(cr.findOne((long) 1));
                    cr.getCourseList().get(0).setTeacher(teacher);
                } else if (teacher.getId() == 2) {
                    coursesT.add(cr.findOne((long) 2));
                    cr.getCourseList().get(1).setTeacher(teacher);
                } else if (teacher.getId() == 3) {
                    coursesT.add(cr.findOne((long) 3));
                    cr.getCourseList().get(2).setTeacher(teacher);
                }

                teacher.setCourses(coursesT);

            }
            reader2.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error file not found");
            System.exit(0);
        }

        /**
         * add the enrolled students for each course
         * */

        for(Course course:cr.getCourseList()) {
            List <Student> studentsEnrolled = new ArrayList<>();
            if (course.getId() == 1) {
                studentsEnrolled.add(sr.findOne((long) 1));
                studentsEnrolled.add(sr.findOne((long) 2));

            } else if (course.getId() == 2) {
                studentsEnrolled.add(sr.findOne((long) 2));
                studentsEnrolled.add(sr.findOne((long) 3));

            } else if (course.getId() == 3)
                studentsEnrolled.add(sr.findOne((long) 1));

            course.setStudentsEnrolled(studentsEnrolled);

        }

        //System.out.println(cr.getCourseList());
        //ControllerJavaFx cfx=new ControllerJavaFx(cr,sr,tr);
        //Menu menu=new Menu(cr,sr,tr);
        ControllerJavaFx cfx=new ControllerJavaFx(cr,sr,tr);
        cfx.mainMenu();


    }

}
