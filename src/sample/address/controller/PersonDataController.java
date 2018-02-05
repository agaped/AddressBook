package sample.address.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileWriter;
import java.io.IOException;
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
    static final String FILE = "C:\\Users\\Agunia\\Desktop\\AddressBook\\src\\sample\\address\\controller\\PersonList";

    @FXML
    public void initialize() throws IOException {
        Person person=new Person();
        List<Person> arrayList = new ArrayList<>();
        arrayList=person.readFromFile(FILE);
        persons= FXCollections.observableArrayList(arrayList);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        personTable.setItems(persons);

        saveButton.setVisible(false);
        discardButton.setVisible(false);
    }

    @FXML
    public void addPerson() throws IOException{
        if(!nameText.getText().isEmpty() && !surnameText.getText().isEmpty() && !phoneText.getText().isEmpty()) {
            person = new Person(nameText.getText(), surnameText.getText(), phoneText.getText());
            persons.add(person);
            write(persons, FILE);

            nameText.clear();
            surnameText.clear();
            phoneText.clear();
        }else return;
    }

    @FXML
    public void deletePerson() throws IOException{
        persons.remove(personTable.getSelectionModel().getSelectedItem());
        write(persons,FILE);
    }

    @FXML
    public void updatePerson(){
        if(personTable.getSelectionModel().getSelectedItem()!=null) {
            person = personTable.getSelectionModel().getSelectedItem();
            index = persons.indexOf(person);
            nameText.setText(person.getName());
            surnameText.setText(person.getSurname());
            phoneText.setText(person.getPhone());

            addButton.setVisible(false);
            deleteButton.setVisible(false);
            saveButton.setVisible(true);
            discardButton.setVisible(true);
        }else return;

    }
    @FXML
    public void savePerson()throws IOException{
        person=new Person(nameText.getText(),surnameText.getText(),phoneText.getText());
        persons.set(index,person);

        write(persons,FILE);
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

    public void write(ObservableList<Person> persons, String file)throws IOException{
        FileWriter fout = new FileWriter(FILE);
        for (Person p:persons) {
            fout.write(p.toString()+"\r\n");
        }
        fout.close();
    }


}
