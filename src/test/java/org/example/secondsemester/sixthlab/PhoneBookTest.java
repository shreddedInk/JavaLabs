package org.example.secondsemester.sixthlab;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class PhoneBookTest {

    private PhoneBook phoneBook;
    private Human human1;
    private Human human2;
    private Human human3;
    private Human human4;

    @Before
    public void setUp() {
        human1 = new Human("Markov", "Slavic", "Biba", 19);
        human2 = new Human("Moskalenko", "Miron", "Boba", 19);
        human3 = new Human("Sosiska", "V", "Teste", 28);
        human4 = new Human("MoskalenkoMarkov", "Yesterday", "ALLMYTROUBLES", 1000000);

        phoneBook = new PhoneBook();
    }

    @Test
    public void testAddPhoneNumber() {
        List<String> numbers = Arrays.asList("123-456", "789-012");
        assertTrue(phoneBook.addPhoneNumber(human2, numbers));
        assertEquals(Set.of("123-456", "789-012"), phoneBook.listOfNumbersOfHuman(human2));
        assertFalse(phoneBook.addPhoneNumber(human3, List.of("123-456")));
    }

    @Test
    public void testDeletePhoneNumber() {
        List<String> numbers = Arrays.asList("999-999", "000-000", "777-777", "777-777");
        phoneBook.addPhoneNumber(human1, numbers);
        phoneBook.deletePhoneNumber(human1, "777-777");
        assertEquals(Set.of("999-999", "000-000"), phoneBook.listOfNumbersOfHuman(human1));
    }

    @Test
    public void testListOfNumbersOfHuman() {
        List<String> numbers = Arrays.asList("123-456", "789-012");
        phoneBook.addPhoneNumber(human1, numbers);
        assertEquals(Set.of("123-456", "789-012"), phoneBook.listOfNumbersOfHuman(human1));
    }

    @Test
    public void testFindHumanByNumber() {
        phoneBook.addPhoneNumber(human1, List.of("123-456"));
        phoneBook.addPhoneNumber(human2, List.of("999-999"));

        assertEquals(human1, phoneBook.findHumanByNumber("123-456"));
        assertEquals(human2, phoneBook.findHumanByNumber("999-999"));
        assertNull(phoneBook.findHumanByNumber("000-000"));
    }

    @Test
    public void testFindSomeoneBySurname() {
        phoneBook.addPhoneNumber(human2, List.of("999-999"));
        phoneBook.addPhoneNumber(human4, List.of("777-777"));

        Map<Human, Set<String>> result = phoneBook.findSomeoneBySurname("Moskalenko");

        assertEquals(2, result.size());
        assertTrue(result.containsKey(human2));
        assertTrue(result.containsKey(human4));
        assertEquals(Set.of("999-999"), result.get(human2));
        assertEquals(Set.of("777-777"), result.get(human4));
    }
}
