package sample.address.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    @FXML
    Button deleteButton;
    @FXML
    Button updateButton;
    @FXML
    Button saveButton;
    @FXML
    Button discardButton;

    private ObservableList<Person> persons;
    private Person person;
    int index=0;

    @FXML
    public void initialize() {
        List<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("Hans", "Zimmer","500 230 300"));
        arrayList.add(new Person("Hans", "Zimmer","600 230 300"));
        persons= FXCollections.observableArrayList(arrayList);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        personTable.setItems(persons);

        saveButton.setVisible(false);
        discardButton.setVisible(false);

    }

    @FXML
    public void addPerson(){
        person=new Person(nameText.getText(),surnameText.getText(),phoneText.getText());
        persons.add(person);

        printPersons();

        nameText.clear();
        surnameText.clear();
        phoneText.clear();
    }

    @FXML
    public void deletePerson(){
        persons.remove(personTable.getSelectionModel().getSelectedItem());

        printPersons();
    }
    @FXML
    public void updatePerson(){
        person=personTable.getSelectionModel().getSelectedItem();
        index=persons.indexOf(person);
        nameText.setText(person.getName());
        surnameText.setText(person.getSurname());
        phoneText.setText(person.getPhone());

        addButton.setVisible(false);
        deleteButton.setVisible(false);
        saveButton.setVisible(true);
        discardButton.setVisible(true);
    }
    @FXML
    public void savePerson(){
        person=new Person(nameText.getText(),surnameText.getText(),phoneText.getText());
        persons.set(index,person);

        discardPerson();
    }
    @FXML
    public void discardPerson(){
        addButton.setVisible(true);
        deleteButton.setVisible(true);
        saveButton.setVisible(false);
        discardButton.setVisible(false);

        nameText.clear();
        surnameText.clear();
        phoneText.clear();
    }

    public void printPersons(){
        for (Person p:persons) {
            System.out.println(p);
        }
    }
}
