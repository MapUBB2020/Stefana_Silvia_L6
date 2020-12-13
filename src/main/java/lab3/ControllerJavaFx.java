package lab3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void menuTeacher(javafx.event.ActionEvent e) throws IOException {
        Parent finishRoot = FXMLLoader.load(getClass().getResource("/lab3/abc.fxml"));
        Scene menuT=new Scene(finishRoot);
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(menuT);
        stage.show();

    }

    public void checkId(javafx.event.ActionEvent e) throws IOException {

        label1.setText("Stefana Bieber-Selly");

    }
}
