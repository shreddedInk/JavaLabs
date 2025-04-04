package org.example.secondsemester.seventhlab.serialize;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    private static final String TEST_FILE = "test_house.ser";

    @Test
    void testSerializationAndDeserialization() throws Exception {
        Person owner = new Person("Марков", "Вячеслав", "Романович", LocalDate.of(2005, 1, 1));
        Flat flat = new Flat(10, 60.0, List.of(owner));
        House house = new House("123213", "хороший", owner, List.of(flat));

        Service.serializeHouse(house, TEST_FILE);
        House deserializedHouse = Service.deserializeHouse(TEST_FILE);

        assertEquals(house, deserializedHouse, "Объекты должны быть равны после сериализации и десериализации");
    }

    @Test
    public void testSerializationToString() throws Exception {
        Person owner = new Person("John", "Doe", "Middle", LocalDate.of(1900, 1, 1));
        Flat flat = new Flat(10, 60.0, List.of(owner));
        House house = new House("123-ABC", "Main Street 1", owner, List.of(flat));

        String json = Service.serializeHouseToJson(house);
        System.out.println("Serialized JSON: " + json); // Для отладки

        House deserializedHouse = Service.deserializeHouseFromJson(json);
        assertEquals(house, deserializedHouse, "Объекты должны быть равны после сериализации и десериализации в JSON");
    }

    @AfterEach
    void cleanUp() {
        try {
            Files.deleteIfExists(Paths.get(TEST_FILE));
        } catch (Exception ignored) {}
    }
}