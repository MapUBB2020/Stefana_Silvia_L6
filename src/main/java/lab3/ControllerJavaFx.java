package lab3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lab3.repository.CourseFileRepository;
import lab3.repository.StudentFileRepository;
import lab3.repository.TeacherFileRepository;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerJavaFx implements Initializable {


    Stage stage= new Stage();

    @FXML
    Label label1;
    @FXML
    TextField loginInput;


    CourseFileRepository cr;
    StudentFileRepository sr;
    TeacherFileRepository tr;
    private static lab3.RegistrationSystem rs;

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

        Parent root = FXMLLoader.load(getClass().getResource("/lab3/uniApp.fxml"));
        s.setTitle("Platforma academica a Stefanei si a Silviei! Please like and subscribe.");
        s.setScene(new Scene(root, 900, 700));
        s.show();

        System.out.println(cr.getCourseList());

    }


    public void menuTeacher(javafx.event.ActionEvent e) throws IOException {
        Parent finishRoot = FXMLLoader.load(getClass().getResource("/lab3/abc.fxml"));
        Scene menuT=new Scene(finishRoot);
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(menuT);
        stage.show();
        System.out.println(cr.getCourseList());

    }

    public void checkId(javafx.event.ActionEvent e) throws IOException {





    }

    public void abc(){
        String login= loginInput.getText();
        if(tr.findOne(Long.parseLong(login))!=null)
            System.out.println("ok");

    }
}
