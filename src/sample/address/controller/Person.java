package sample.address.controller;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by agaped on 01.02.2018.
 */
public class Person {

    private final SimpleStringProperty name;
    private final SimpleStringProperty surname;
    private final SimpleStringProperty phone;

    public Person(String name, String surname, String phone) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.phone = new SimpleStringProperty(phone);
    }

    public Person() {
        this.name = new SimpleStringProperty();
        this.surname = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
    }

    public String getName() {
        return name.get();
    }

//    public SimpleStringProperty nameProperty() {
//        return name;
//    }

    public String getSurname() {
        return surname.get();
    }

//    public SimpleStringProperty surnameProperty() {
//        return surname;
//    }

    public String getPhone() {
        return phone.get();
    }

//    public SimpleStringProperty phoneProperty() {
//        return phone;
//    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " " + getPhone();
    }


}


