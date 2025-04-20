package org.example.secondsemester.ninethlab;

import org.example.secondsemester.eighthlab.ReflectionDemo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LambdaDemoTest {

    @Test
    void testLambdaSpaces() {
        String s = "test smthg";
        System.out.println(LambdaDemo.string_no_spaces.apply(s));
    }

    @Test
    void testLambdaWords() {
        String s = "Hello, world, i, love, java";
        System.out.println(LambdaDemo.string_count_of_words.apply(s));
    }

}