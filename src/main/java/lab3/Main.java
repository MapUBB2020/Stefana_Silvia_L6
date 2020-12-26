package lab3;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        JsonReader.read();
    }


    public static void main(String[] args) throws IOException {

        launch(args);
}
}



