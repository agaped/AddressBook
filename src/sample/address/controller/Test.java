package sample.address.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Agunia on 05.02.2018.
 */
public class Test {
    static final String FILE = "C:\\Users\\Agunia\\Desktop\\AddressBook\\src\\sample\\address\\controller\\PersonList";
    public static void main(String[] args) throws IOException {
            Person person=new Person();
            ArrayList<Person> arrayList=new ArrayList<>();
            arrayList=person.readFromFile(FILE);
            ObservableList<Person> persons= FXCollections.observableArrayList(arrayList);

        for (Person p:persons) {
            System.out.println(p);
        }

        persons.add(new Person("Boro","Borowski","300300200"));
        System.out.println("*********************************************");
        for (Person p:persons) {
            System.out.println(p);
        }
        write(persons);

    }

    public static void write(ObservableList<Person> persons)throws IOException{
        FileWriter fout = new FileWriter(FILE);
        for (Person p:persons) {
            fout.write(p.toString()+"\r\n");
        }
        fout.close();
    }
}
