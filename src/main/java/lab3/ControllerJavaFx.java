package lab3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lab3.model.Course;
import lab3.model.Student;
import lab3.model.Teacher;
import lab3.repository.CourseFileRepository;
import lab3.repository.StudentFileRepository;
import lab3.repository.TeacherFileRepository;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerJavaFx implements Initializable {

    @FXML
    public TextField loginInput;
    @FXML
    public Label loginError;
    @FXML
    public Label teacherName;
    @FXML
    public Label coursesTeacher;
    @FXML
    public TextField idCourse;
    @FXML
    public Label courseLabel;
    @FXML
    public Button sendButton;
    @FXML
    public Label numeStudent;
    @FXML
    public Button allCourses;
    @FXML
    public Button freePlaces;
    @FXML
    public Button register;
    @FXML
    public Label results;


    Stage stage= new Stage();

    public CourseFileRepository cr;
    public StudentFileRepository sr;
    public TeacherFileRepository tr;
    private static lab3.RegistrationSystem rs;

    public CourseFileRepository getCr() {
        return cr;
    }

    public void setCr(CourseFileRepository cr) {
        this.cr = cr;
    }

    public StudentFileRepository getSr() {
        return sr;
    }

    public void setSr(StudentFileRepository sr) {
        this.sr = sr;
    }

    public TeacherFileRepository getTr() {
        return tr;
    }

    public void setTr(TeacherFileRepository tr) {
        this.tr = tr;
    }

    public static RegistrationSystem getRs() {
        return rs;
    }

    public static void setRs(RegistrationSystem rs) {
        ControllerJavaFx.rs = rs;
    }

    public ControllerJavaFx() {}

    public ControllerJavaFx(CourseFileRepository cr, StudentFileRepository sr, TeacherFileRepository tr) {
        this.cr = cr;
        this.sr = sr;
        this.tr = tr;
        rs=new lab3.RegistrationSystem(cr,tr);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void mainMenu() throws IOException {
        Stage s=new Stage();

        FXMLLoader loader =new FXMLLoader(getClass().getResource("/lab3/uniApp.fxml"));
        s.setTitle("Platforma academica a Stefanei si a Silviei! Please like and subscribe.");
        loader.setController(this);
        Parent root=loader.load();
        s.setScene(new Scene(root, 900, 700));
        s.show();

        //System.out.println(cr.getCourseList());
    }


    public void loginTeacherPage(javafx.event.ActionEvent e) throws IOException {/*
        Parent finishRoot = FXMLLoader.load(getClass().getResource("/lab3/abc.fxml"));
        Scene menuT=new Scene(finishRoot);
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(menuT);
        stage.show();
        System.out.println(cr.getCourseList());*/
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/lab3/abc.fxml"));
        loader1.setController(this);
        Parent finishRoot=loader1.load();
        Scene menuT=new Scene(finishRoot);
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(menuT);
        stage.show();
        //System.out.println(sr.getStudentList());

    }

    public void checkId(javafx.event.ActionEvent e) throws IOException {
        String loginTeacher=loginInput.getText();
        //System.out.println(sr.getStudentList().get(0).getTotalCredits());
        //System.out.println(sr.getStudentList());
        if(tr.findOne(Long.parseLong(loginTeacher))==null)
            loginError.setText("bitch u entered the wrong id!");
        else
            menuTeacher(e,Long.parseLong(loginTeacher));
/*        for (int i=0; i<tr.getTeacherList().size();i++){

            if (loginTeacher==tr.getTeacherList().get(i).getFirstName()+" "+tr.getTeacherList().get(i).getLastName()){
                System.out.println("sal");
                menuStudent(e,tr.getTeacherList().get(i).getId());}
            else
                loginError.setText("bitch u entered the wrong id!");
        }*/

    }


    public void menuTeacher(javafx.event.ActionEvent e,Long id) throws IOException {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/lab3/menuTeacher.fxml"));
        loader2.setController(this);
        Parent finishRoot=loader2.load();
        Scene menuT=new Scene(finishRoot);
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(menuT);
        stage.show();

        teacherName.setText(tr.findOne(id).getFirstName()+" "+tr.findOne(id).getLastName());
        coursesTeacher.setText(tr.findOne(id).getCourses().get(0).getName()+" id: "+tr.findOne(id).getCourses().get(0).getId());

        sendButton.setOnAction(actionEvent -> {
            infoCourse(id);
        });
    }



    public void infoCourse(Long id){
/*        for (Course course:cr.getCourseList()) {
            for (Student student : course.getStudentsEnrolled()) {

                courseLabel.setText("Studentii inscrisi la cursul dumneavoastra sunt:\n" + cr.findOne(id).getStudentsEnrolled().get(0).getFirstName() + " " + cr.findOne(id).getStudentsEnrolled().get(0).getLastName());
            }
        }*/
        for (int i=0; i<cr.findOne(id).getStudentsEnrolled().size();i++) {
            courseLabel.setText("Studentii inscrisi la cursul dumneavoastra sunt:\n" + cr.findOne(id).getStudentsEnrolled().get(i).getFirstName() + " " + cr.findOne(id).getStudentsEnrolled().get(i).getLastName());
            System.out.println(cr.findOne(id).getStudentsEnrolled());
        }
    }

    public void loginStudentPage(javafx.event.ActionEvent e) throws IOException {

        FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/lab3/abcStud.fxml"));
        loader4.setController(this);
        Parent finishRoot=loader4.load();
        Scene menuS=new Scene(finishRoot);
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(menuS);
        stage.show();

    }

    public void menuStudent(javafx.event.ActionEvent e,Long id) throws IOException {
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/lab3/menuStudent.fxml"));
        loader3.setController(this);
        Parent finishRoot=loader3.load();
        Scene menuS=new Scene(finishRoot);
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(menuS);
        stage.show();

        numeStudent.setText(sr.findOne(id).getFirstName()+" "+sr.findOne(id).getLastName());

        register.setOnAction(actionEvent -> {
            rs.register(id, sr.findOne(id));
            results.setText("bv te ai inregistrat");
        });

        allCourses.setOnAction(actionEvent -> {
            rs.getAllCourses();
        });

        freePlaces.setOnAction(actionEvent -> {
            rs.retrieveCoursesWithFreePlaces();
        });
    }
    public void checkIdStudent(javafx.event.ActionEvent e) throws IOException {
        String loginStudent=loginInput.getText();
        if(sr.findOne(Long.parseLong(loginStudent))==null)
            loginError.setText("bitch u entered the wrong id!");
        else
            menuStudent(e,Long.parseLong(loginStudent));

    }

    }

