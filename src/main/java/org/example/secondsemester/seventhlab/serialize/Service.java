package org.example.secondsemester.seventhlab.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;

public class Service {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }


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

    public static String serializeHouseToJson(House house) throws JsonProcessingException {
        return objectMapper.writeValueAsString(house);
    }

    public static House deserializeHouseFromJson(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, House.class);
    }
}
