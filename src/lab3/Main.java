package lab3;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

       // Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        primaryStage.setTitle("Examenul auto al Stefanei si al Silviei! Please like and subscribe.");
        //primaryStage.setScene(new Scene(root, 1100, 800));

        primaryStage.show();

    }


    public static void main(String[] args) throws IOException {
        launch(args);
    }
}



