package sample.address;
/**
 * Created by agaped on 01.02.2018.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.address.controller.Person;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) throws IOException {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/PersonDetails.fxml"));
        primaryStage.setTitle("Address Book");
        Scene scene=new Scene(root, 450, 500);
        primaryStage.setScene(scene);
        //File f = new File("src/sample/view/javafx.css");
        //scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        primaryStage.show();

    }

}
