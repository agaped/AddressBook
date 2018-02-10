package sample.address;
/**
 * Created by agaped on 01.02.2018.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("view/PersonDetails.fxml"));
        primaryStage.setTitle("Address Book");
        Scene scene = new Scene(root, 450, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
