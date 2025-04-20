package org.example.secondsemester.eighthlab;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AdditionalTasksTest {

    static class TestExecutable implements Executable {

        @Override
        public void execute() {
            System.out.println("executed");
        }
    }

    static class TestClass {
        private String name;
        private int value;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getValue() { return value; }
        public void setValue(int value) { this.value = value; }
        public static void staticMethod() {}
        private void privateMethod() {}
        public void nonGetterSetter() {}
    }

    @Test
    void executeElementsImplementingExecutable() {
        TestExecutable executable1 = new TestExecutable();
        TestExecutable executable2 = new TestExecutable();
        Object nonExecutable = new Object();

        List<Object> list = new ArrayList<>();
        list.add(executable1);
        list.add(nonExecutable);
        list.add(executable2);

        int count = ReflectionDemo.executeElementsImplementingExecutable(list);

        assertEquals(2, count);
    }

    @Test
    void executeElementsImplementingExecutableEmpty() {
        List<Object> emptyList = new ArrayList<>();

        int count = ReflectionDemo.executeElementsImplementingExecutable(emptyList);

        assertEquals(0, count);
    }


    @Test
    void getGettersAndSetters() {
        TestClass testObject = new TestClass();

        List<String> result = ReflectionDemo.getGettersAndSetters(testObject);

        System.out.println(result);

        assertEquals(5, result.size());
        assertTrue(result.contains("getClass"));
        assertTrue(result.contains("getName"));
        assertTrue(result.contains("setName"));
        assertTrue(result.contains("getValue"));
        assertTrue(result.contains("setValue"));
        assertFalse(result.contains("staticMethod"));
        assertFalse(result.contains("privateMethod"));
        assertFalse(result.contains("nonGetterSetter"));
    }
}