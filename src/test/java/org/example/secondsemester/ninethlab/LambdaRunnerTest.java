package org.example.secondsemester.ninethlab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LambdaRunnerTest {

    private static final Human person1 = new Human("Moskalenko", "Miron", "Valerievich", 19, Human.Gender.MALE);
    private static final Human person2 = new Human("askdad", "dasdsadad", "dasdsad", 30, Human.Gender.FEMALE);
    private static final Human person3 = new Human("Markov", "Slavic", null, 20, Human.Gender.MALE);
    private static final Human person4 = new Human("Moskalenko", "xczzxcxcz", "axe305155", 999, Human.Gender.MALE);

    @Test
    void testRunStringOperator() {
        assertEquals(5, LambdaRunner.runStringOperator(LambdaDemo.string_length, "Hello"));
        assertEquals(0, LambdaRunner.runStringOperator(LambdaDemo.string_length, ""));
    }

    @Test
    void testRunFirstLetterOperator() {
        assertEquals('H', LambdaRunner.runFirstLetterOperator(LambdaDemo.string_first_letter, "Hello"));
        assertNull(LambdaRunner.runFirstLetterOperator(LambdaDemo.string_first_letter, ""));
        assertNull(LambdaRunner.runFirstLetterOperator(LambdaDemo.string_first_letter, null));
    }

    @Test
    void testRunSpacesOperator() {
        assertTrue(LambdaRunner.runSpacesOperator(LambdaDemo.string_no_spaces, "Hello World"));
        assertFalse(LambdaRunner.runSpacesOperator(LambdaDemo.string_no_spaces, "Hello"));
    }

    @Test
    void testRunWordsCountOperator() {
        assertEquals(3, LambdaRunner.runWordsCountOperator(LambdaDemo.string_count_of_words, "one,two,three"));
        assertEquals(1, LambdaRunner.runWordsCountOperator(LambdaDemo.string_count_of_words, "single"));
    }

    @Test
    void testRunHumanAgeOperator() {
        assertEquals(19, LambdaRunner.runHumanAgeOperator(LambdaDemo.human_age, person1));
        assertEquals(30, LambdaRunner.runHumanAgeOperator(LambdaDemo.human_age, person2));
    }

    @Test
    void testRunSameSurnamesOperator() {
        assertTrue(LambdaRunner.runSameSurnamesOperator(LambdaDemo.human_same_surnames, person1, person4));
        assertFalse(LambdaRunner.runSameSurnamesOperator(LambdaDemo.human_same_surnames, person1, person2));
    }

    @Test
    void testRunFullNameOperator() {
        assertEquals("Moskalenko Miron Valerievich",
                LambdaRunner.runFullNameOperator(LambdaDemo.human_get_full_name, person1));
        assertEquals("Markov Slavic null",
                LambdaRunner.runFullNameOperator(LambdaDemo.human_get_full_name, person3));
    }

    @Test
    void testRunMakeOlderOperator() {
        Human olderPerson = LambdaRunner.runMakeOlderOperator(LambdaDemo.human_make_older, person1);
        assertEquals(20, olderPerson.getAge());
        assertEquals("Moskalenko", olderPerson.getLastName());

        assertNull(LambdaRunner.runMakeOlderOperator(LambdaDemo.human_make_older, null));
    }

    @Test
    void testRunAgeCheckerOperator() {
        assertTrue(LambdaRunner.runAgeCheckerOperator(
                LambdaDemo.human_age_checker,
                person1, person2, person3,
                35
        ));

        assertFalse(LambdaRunner.runAgeCheckerOperator(
                LambdaDemo.human_age_checker,
                person1, person2, person4,
                10
        ));
    }
}