package sample.address.controller;

import javafx.beans.property.StringProperty;

/**
 * Created by agaped on 01.02.2018.
 */
public class Person {

    private final String name;
    private final String surname;
    private final String phone;

    public Person(String name, String surname, String phone) {
        this.name = name;
        this.phone = phone;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }
}


