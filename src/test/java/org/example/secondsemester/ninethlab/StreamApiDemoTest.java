package org.example.secondsemester.ninethlab;

import org.example.secondsemester.ninethlab.StreamApiDemo;
import org.example.secondsemester.ninethlab.Human;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class StreamApiDemoTest {

    @Test
    public void testRemoveNulls() {
        List<Object> input = Arrays.asList("A", null, "B", null, "C");
        List<Object> expected = Arrays.asList("A", "B", "C");
        assertEquals(expected, StreamApiDemo.remove_nulls.apply(input));
    }

    @Test
    public void testCountPositiveNumbers() {
        Set<Integer> input = new HashSet<>(Arrays.asList(-3, 0, 5, 7, -1));
        assertEquals(2, StreamApiDemo.count_positive_numbers.apply(input));
    }

    @Test
    public void testLastThreeElements() {
        List<Object> input = Arrays.asList("A", "B", "C", "D", "E");
        List<Object> expected = Arrays.asList("C", "D", "E");
        assertEquals(expected, StreamApiDemo.last_three_elements.apply(input));
    }

    @Test
    public void testFirstEvenOrNull_Found() {
        List<Integer> input = Arrays.asList(1, 3, 5, 6, 7);
        assertEquals(6, StreamApiDemo.first_even_or_null.apply(input));
    }

    @Test
    public void testFirstEvenOrNull_NotFound() {
        List<Integer> input = Arrays.asList(1, 3, 5, 7);
        assertNull(StreamApiDemo.first_even_or_null.apply(input));
    }

    @Test
    public void testUniqueSquares() {
        int[] input = {1, 2, -2, 3, 1};
        List<Integer> expected = Arrays.asList(1, 4, 9);
        assertEquals(expected, StreamApiDemo.unique_squares.apply(input));
    }

    @Test
    public void testSortedNonEmptyStrings() {
        List<String> input = Arrays.asList("apple", "", null, "banana", "cherry");
        List<String> expected = Arrays.asList("apple", "banana", "cherry");
        assertEquals(expected, StreamApiDemo.sorted_non_empty_strings.apply(input));
    }

    @Test
    public void testSortedDescendingStrings() {
        Set<String> input = new HashSet<>(Arrays.asList("beta", "alpha", "gamma"));
        List<String> expected = Arrays.asList("gamma", "beta", "alpha");
        assertEquals(expected, StreamApiDemo.sorted_descending_strings.apply(input));
    }

    @Test
    public void testSumOfSquares() {
        Set<Integer> input = new HashSet<>(Arrays.asList(1, 2, 3));
        int expected = 1*1 + 2*2 + 3*3;
        assertEquals(expected, StreamApiDemo.sum_of_squares.applyAsInt(input));
    }

    @Test
    public void testMaxHumanAge() {
        List<Human> people = Arrays.asList(
                new Human("Moskalenko", "Miron", "asdsadsad", 19, Human.Gender.MALE),
                new Human("Markov", "Slavic", "vzvzxvxv", 20, Human.Gender.MALE),
                new Human("Teplyakov", "Dmitriy", "", 40, Human.Gender.FEMALE)
        );
        assertEquals(40, StreamApiDemo.max_human_age.apply(people));
    }

    @Test
    public void testSortByGenderThenAge() {
        List<Human> people = Arrays.asList(
                new Human("Ibraev", "dasdsad", "adsadadsa", 40, Human.Gender.FEMALE),
                new Human("Moskalenko", "Miron", "asdsadsad", 19, Human.Gender.MALE),
                new Human("Markov", "Slavic", "vzvzxvxv", 20, Human.Gender.MALE),
                new Human("Kruglov", "dasdasdas", "asdad", 20, Human.Gender.FEMALE)
        );

        List<Human> sorted = StreamApiDemo.sort_by_gender_then_age.apply(people);

        assertEquals("Kruglov", sorted.get(0).getLastName()); // FEMALE, 20
        assertEquals("Ibraev", sorted.get(1).getLastName());  // FEMALE, 40
        assertEquals("Moskalenko", sorted.get(2).getLastName());  // MALE, 19
        assertEquals("Markov", sorted.get(3).getLastName());   // MALE, 20
    }
}
