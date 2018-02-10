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

    public String getName() {
        return name.get();
    }

    public String getSurname() {
        return surname.get();
    }

    public String getPhone() {
        return phone.get();
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " " + getPhone();
    }


}


