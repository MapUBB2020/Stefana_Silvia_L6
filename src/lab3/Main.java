package lab3;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lab3.model.Course;
import lab3.model.Teacher;
import lab3.repository.CourseFileRepository;

import java.io.IOException;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("uniApp.fxml"));
        primaryStage.setTitle("Examenul auto al Stefanei si al Silviei! Please like and subscribe.");
        primaryStage.setScene(new Scene(root, 900, 700));

        primaryStage.show();

    }


    public static void main(String[] args) throws IOException {
        launch(args);
        JsonReader js = new JsonReader();
        Teacher teacher=new Teacher();
        CourseFileRepository cfr=new CourseFileRepository(js.jsonReaderCourses());
        cfr.setCourseList(js.jsonReaderCourses());
        //System.out.println(cfr.getCourseList());
}
}



