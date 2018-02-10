package sample.address.controller;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by agaped on 10.02.2018.
 */
public class FileManager {

    public static ArrayList<Person> readFromFile(String file) throws FileNotFoundException {
        List<Person> arrayList = new ArrayList<>();
        File f = new File(file);
        Scanner fin = new Scanner(f);
        while (fin.hasNext()) {
            String n = fin.next();
            String s = fin.next();
            String p = fin.next();
            arrayList.add(new Person(n, s, p));
        }
        return (ArrayList<Person>) arrayList;
    }

    public static void writeToFile(ObservableList<Person> persons, String file) throws IOException {
        FileWriter fout = new FileWriter(file);
        for (Person p : persons) {
            fout.write(p.toString() + "\r\n");
        }
        fout.close();
    }
}
