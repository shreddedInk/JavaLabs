package org.example.secondsemester.eighthlab;

import org.example.secondsemester.sixthlab.Human;
import org.example.secondsemester.sixthlab.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionDemoTest {

    @Test
    void testSearchCountOfElementsOfHuman() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Human("dasdasda", "dsadsa", "dasdsa", 999));
        list.add("String");
        list.add(new Human("gdfgdfgdfg", "fdhfhgf", null, 123));
        list.add(12345);
        list.add(new Student("dsadsa", "dasdsa", "dasdsadsa", 123, "dasdas"));

        assertEquals(3, ReflectionDemo.SearchCountOfElementsOfHuman(list));
    }

    @Test
    void testSearchCountOfElementsOfHumanWithNoHumans() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("something");
        list.add(12345);

        assertEquals(0, ReflectionDemo.SearchCountOfElementsOfHuman(list));
    }

    @Test
    void testSearchCountOfElementsOfHumanWithEmptyList() {
        ArrayList<Object> list = new ArrayList<>();

        assertEquals(0, ReflectionDemo.SearchCountOfElementsOfHuman(list));
    }

    @Test
    void testGetPublicMethods() {
        Human human = new Human("SUS", "SUS", "SUS", 12);
        ArrayList<String> methods = ReflectionDemo.getPublicMethods(human);


        assertTrue(methods.contains("getSurname"));
        assertTrue(methods.contains("getName"));
        assertTrue(methods.contains("getPatronymic"));
        assertTrue(methods.contains("getAge"));
        assertTrue(methods.contains("setSurname"));
        assertTrue(methods.contains("setName"));
        assertTrue(methods.contains("setPatronymic"));
        assertTrue(methods.contains("setAge"));
        assertTrue(methods.contains("equals"));
        assertTrue(methods.contains("hashCode"));
        assertTrue(methods.contains("compareTo"));
        assertFalse(methods.contains("Test"));
    }

    @Test
    void testGetPublicMethodsWithNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            ReflectionDemo.getPublicMethods(null);
        });
    }

    @Test
    void testGetAllNamesOfSuperClassesForHuman() {
        Human human = new Human("asdada", "dasdasd", "dasdas", 999);
        ArrayList<String> superClasses = ReflectionDemo.getAllNamesOfSuperClasses(human);

        assertEquals(2, superClasses.size());
        assertEquals("org.example.secondsemester.sixthlab.Human", superClasses.get(0));
        assertEquals("java.lang.Object", superClasses.get(1));
    }

    @Test
    void testGetAllNamesOfSuperClassesForString() {
        ArrayList<String> superClasses = ReflectionDemo.getAllNamesOfSuperClasses("test");

        assertTrue(superClasses.contains("java.lang.String"));
        assertTrue(superClasses.contains("java.lang.Object"));
    }

    @Test
    void testGetAllNamesOfSuperClassesForObject() {
        ArrayList<String> superClasses = ReflectionDemo.getAllNamesOfSuperClasses(new Object());

        assertEquals(1, superClasses.size());
        assertEquals("java.lang.Object", superClasses.getFirst());
    }
}