package sample.address.controller;

import javafx.beans.property.SimpleStringProperty;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public Person(){
        this.name = new SimpleStringProperty();
        this.surname = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
    }
    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    @Override
    public String toString(){
        return getName()+" "+getSurname()+" "+getPhone();
    }

    public ArrayList<Person> readFromFile(String file) throws IOException{
        List<Person> arrayList = new ArrayList<>();
        File f = new File(file);
        Scanner fin = new Scanner(f);
        while(fin.hasNext()) {
            String n=fin.next();
            String s=fin.next();
            String p=fin.next();
            arrayList.add(new Person(n,s,p));
        }
        return (ArrayList<Person>) arrayList;
    }

}


