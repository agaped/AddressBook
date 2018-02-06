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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    Label warningLabel;

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
    int index = 0;
    static final String FILE = "src\\sample\\address\\controller\\PersonList";
    Pattern patternName = Pattern.compile("[A-Z][a-z]{1,}");
    Pattern patternPhone = Pattern.compile("[0-9]{3}-[0-9]{3}-[0-9]{3}");


    @FXML
    public void initialize() throws IOException {
        Person person = new Person();
        List<Person> arrayList = new ArrayList<>();
        arrayList = person.readFromFile(FILE);
        persons = FXCollections.observableArrayList(arrayList);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        personTable.setItems(persons);

        saveButton.setVisible(false);
        discardButton.setVisible(false);
        warningLabel.setVisible(false);
    }

    @FXML
    public void addPerson() throws IOException {
        if (!nameText.getText().isEmpty() && !surnameText.getText().isEmpty() && !phoneText.getText().isEmpty()) {
            Matcher matcherName = patternName.matcher(nameText.getText());
            Matcher matcherSurname = patternName.matcher(surnameText.getText());
            Matcher matcherPhone = patternPhone.matcher(phoneText.getText());
            if (matcherName.matches() && matcherSurname.matches() && matcherPhone.matches()) {
                person = new Person(nameText.getText(), surnameText.getText(), phoneText.getText());
                persons.add(person);
                writeToFile(persons, FILE);

                nameText.clear();
                surnameText.clear();
                phoneText.clear();

                warningLabel.setVisible(false);
            } else {
                warningLabel.setVisible(true);
                warningLabel.setText("Wrong data format: Jan Kowalski 560-768-987");
            }
        } else {
            warningLabel.setVisible(true);
            warningLabel.setText("Wrong data format: Jan Kowalski 560-768-987");
        }
    }

    @FXML
    public void deletePerson() throws IOException {
        persons.remove(personTable.getSelectionModel().getSelectedItem());
        writeToFile(persons, FILE);
    }

    @FXML
    public void updatePerson() {
        if (personTable.getSelectionModel().getSelectedItem() != null) {
            person = personTable.getSelectionModel().getSelectedItem();
            index = persons.indexOf(person);
            nameText.setText(person.getName());
            surnameText.setText(person.getSurname());
            phoneText.setText(person.getPhone());

            addButton.setVisible(false);
            deleteButton.setVisible(false);
            saveButton.setVisible(true);
            discardButton.setVisible(true);
        } else return;

    }

    @FXML
    public void savePerson() throws IOException {
        if (!nameText.getText().isEmpty() && !surnameText.getText().isEmpty() && !phoneText.getText().isEmpty()) {
            Matcher matcherName = patternName.matcher(nameText.getText());
            Matcher matcherSurname = patternName.matcher(surnameText.getText());
            Matcher matcherPhone = patternPhone.matcher(phoneText.getText());
            if (matcherName.matches() && matcherSurname.matches() && matcherPhone.matches()) {
                person = new Person(nameText.getText(), surnameText.getText(), phoneText.getText());
                persons.set(index, person);

                writeToFile(persons, FILE);
                discardPerson();
                warningLabel.setVisible(false);
            } else {
                warningLabel.setVisible(true);
                warningLabel.setText("Wrong data format: Jan Kowalski 560-768-987");
            }
        } else {
            warningLabel.setVisible(true);
            warningLabel.setText("Wrong data format: Jan Kowalski 560-768-987");
        }
    }

    @FXML
    public void discardPerson() {
        addButton.setVisible(true);
        deleteButton.setVisible(true);
        saveButton.setVisible(false);
        discardButton.setVisible(false);

        nameText.clear();
        surnameText.clear();
        phoneText.clear();

        warningLabel.setVisible(false);
    }

    public void writeToFile(ObservableList<Person> persons, String file) throws IOException {
        FileWriter fout = new FileWriter(file);
        for (Person p : persons) {
            fout.write(p.toString() + "\r\n");
        }
        fout.close();
    }


}
