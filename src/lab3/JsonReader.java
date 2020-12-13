package lab3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lab3.model.Course;
import lab3.model.Student;
import lab3.model.Teacher;
import lab3.repository.CourseFileRepository;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonReader {


    /**
     * reads from questions.json
     * @return list with all the Question Objects
     * @throws IOException
     */
    public List<Student> jsonReaderStudents() throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path path = Paths.get("student.json");

        List<Student> studentList;

        try (Reader reader = Files.newBufferedReader(path)) {
            studentList = gson.fromJson(reader, new TypeToken<List<Student>>() {
            }.getType());
        }
        return studentList;
    }

    public List<Course> jsonReaderCourses() throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path path = Paths.get("course.json");

        List<Course> courseList;

        try (Reader reader = Files.newBufferedReader(path)) {
            courseList = gson.fromJson(reader, new TypeToken<List<Course>>() {
            }.getType());
        }
        return courseList;
    }

    public List<Teacher> jsonReaderTeachers() throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path path = Paths.get("teacher.json");

        List<Teacher> teacherList;

        try (Reader reader = Files.newBufferedReader(path)) {
            teacherList = gson.fromJson(reader, new TypeToken<List<Teacher>>() {
            }.getType());
        }
        return teacherList;
    }

}
