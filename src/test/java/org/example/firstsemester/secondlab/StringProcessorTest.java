package org.example.firstsemester.secondlab;

import org.example.firstsemester.secondlab.StringProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {

    @Test
    void testCopyString() {
        assertEquals("hellohellohello", StringProcessor.copyString("hello", 3));

        assertEquals("", StringProcessor.copyString("hello", 0));

        assertEquals("", StringProcessor.copyString("", 5));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.copyString("hello", -1);
        });
        assertEquals("N < 0", exception.getMessage());

        assertThrows(NullPointerException.class, () -> StringProcessor.copyString(null, 2));
    }

    @Test
    void testCountEntries() {
        assertEquals(3, StringProcessor.countEntries("banana", "a"));

        assertEquals(0, StringProcessor.countEntries("banana", "x"));

        assertEquals(4, StringProcessor.countEntries("ababababa", "aba"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.countEntries("banana", "");
        });
        assertEquals("Вторая строка не должна быть пустой или null.", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> StringProcessor.countEntries("banana", null));
    }

    @Test
    void testReplaceNumbers() {
        assertEquals("один два три", StringProcessor.replaceNumbers("1 2 3"));

        assertEquals("hello world", StringProcessor.replaceNumbers("hello world"));

        assertEquals("один два три 4", StringProcessor.replaceNumbers("1 2 3 4"));
    }

    @Test
    void testRemoveSecond() {
        StringBuilder input = new StringBuilder("abcdef");
        StringProcessor.removeSecond(input);
        assertEquals("ace", input.toString());

        StringBuilder empty = new StringBuilder("");
        StringProcessor.removeSecond(empty);
        assertEquals("", empty.toString());

        StringBuilder singleChar = new StringBuilder("a");
        StringProcessor.removeSecond(singleChar);
        assertEquals("a", singleChar.toString());
    }

    @Test
    void testReverseString() {
        assertEquals("world hello", StringProcessor.reverseString("hello world"));

        assertEquals("world  hello", StringProcessor.reverseString("hello  world"));
    }

    @Test
    void testHexDecoding() {
        assertEquals("I have 10 apples", StringProcessor.hexDecoding("I have 0xA apples"));

        assertEquals("There are 15 and 255 items", StringProcessor.hexDecoding("There are 0xF and 0xFF items"));

        assertEquals("No hex here", StringProcessor.hexDecoding("No hex here"));

        assertEquals("123456789987654321", StringProcessor.hexDecoding("0x1B69B4BE052FAB1"));
    }
}
