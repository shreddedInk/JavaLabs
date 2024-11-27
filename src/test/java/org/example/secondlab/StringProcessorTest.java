package org.example.secondlab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {

    @Test
    void testCopyString() {
        // Basic test case
        assertEquals("hellohellohello", StringProcessor.copyString("hello", 3));

        // Edge case: N = 0
        assertEquals("", StringProcessor.copyString("hello", 0));

        // Edge case: Empty string
        assertEquals("", StringProcessor.copyString("", 5));

        // Exception case: N < 0
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.copyString("hello", -1);
        });
        assertEquals("N < 0", exception.getMessage());

        // Exception case: String is null
        assertThrows(NullPointerException.class, () -> StringProcessor.copyString(null, 2));
    }

    @Test
    void testCountEntries() {
        // Basic test case
        assertEquals(3, StringProcessor.countEntries("banana", "a"));

        // Edge case: String does not contain target substring
        assertEquals(0, StringProcessor.countEntries("banana", "x"));

        // Edge case: Target string is longer than source string
        assertEquals(4, StringProcessor.countEntries("ababababa", "aba"));

        // Exception case: Target string is empty
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.countEntries("banana", "");
        });
        assertEquals("Вторая строка не должна быть пустой или null.", exception.getMessage());

        // Exception case: Target string is null
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.countEntries("banana", null));
    }

    @Test
    void testReplaceNumbers() {
        // Basic test case
        assertEquals("один два три", StringProcessor.replaceNumbers("1 2 3"));

        // Edge case: No numbers to replace
        assertEquals("hello world", StringProcessor.replaceNumbers("hello world"));

        // Edge case: String contains numbers outside of 1, 2, 3
        assertEquals("один два три 4", StringProcessor.replaceNumbers("1 2 3 4"));
    }

    @Test
    void testRemoveSecond() {
        // Basic test case
        StringBuilder input = new StringBuilder("abcdef");
        StringProcessor.removeSecond(input);
        assertEquals("ace", input.toString());

        // Edge case: Empty string
        StringBuilder empty = new StringBuilder("");
        StringProcessor.removeSecond(empty);
        assertEquals("", empty.toString());

        // Edge case: One character string
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
