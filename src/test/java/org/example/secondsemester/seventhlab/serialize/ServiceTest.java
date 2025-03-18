package org.example.secondsemester.seventhlab.serialize;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    private static final String TEST_FILE = "test_house.ser";

    @Test
    void testSerializationAndDeserialization() throws Exception {
        Person owner = new Person("Марков", "Вячеслав", "Романович", new Date());
        Flat flat = new Flat(10, 60.0, List.of(owner));
        House house = new House("123213", "хороший", owner, List.of(flat));

        Service.serializeHouse(house, TEST_FILE);
        House deserializedHouse = Service.deserializeHouse(TEST_FILE);

        assertEquals(house, deserializedHouse, "Объекты должны быть равны после сериализации и десериализации");
    }

    @AfterEach
    void cleanUp() {
        try {
            Files.deleteIfExists(Paths.get(TEST_FILE));
        } catch (Exception ignored) {}
    }
}
