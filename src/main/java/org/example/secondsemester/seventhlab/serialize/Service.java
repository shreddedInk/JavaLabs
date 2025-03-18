package org.example.secondsemester.seventhlab.serialize;

import java.io.*;
import java.util.*;
import java.util.Objects;

public class Service {
    public static void serializeHouse(House house, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(house);
        }
    }

    public static House deserializeHouse(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (House) ois.readObject();
        }
    }
}
