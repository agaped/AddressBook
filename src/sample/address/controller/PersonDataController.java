package sample.address.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agaped on 01.02.2018.
 */
public class PersonDataController {

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> surnameColumn;
    @FXML
    private TableColumn<Person, String> phoneColumn;

    @FXML
    Label nameLabel;
    @FXML
    Label surnameLabel;
    @FXML
    Label phoneLabel;

    @FXML
    TextField nameText;
    @FXML
    TextField surnameText;
    @FXML
    TextField phoneText;

    @FXML
    Button addButton;

    private ObservableList<Person> persons;
    private Person person;
    private final TableView<Person> table = new TableView<>();

//    public PersonOverviewController() {
//    }


    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        List<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("Hans", "Hans","500 002 300"));

        persons= FXCollections.observableArrayList(arrayList);


    }

    @FXML
    public void addPerson(){
        person=new Person(nameText.getText(),surnameText.getText(),phoneText.getText());
        persons.add(person);
        System.out.println(persons);
    }
//    public void delete(Person person){
//        persons.remove(person);
//    }
//    public void update(Person person){
//        persons.;
//    }
}
