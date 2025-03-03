package org.example.secondsemester.sixthlab;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class DataDemoTest {
    private Data data;
    private Group group1;
    private Group group2;

    @Before
    public void setUp() {
        group1 = new Group(1, 1, 2, 3, 4, 5, 6);
        group2 = new Group(2, 12, 12, 14, 15, 16, 17);
        data = new Data("Test data", group1, group2);
    }

    @Test
    public void iteratorTest(){
        ArrayList<Integer> listTest = DataDemo.getAll(data);
        System.out.println(DataDemo.getAll(data));
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 12, 12, 14, 15, 16, 17));

        assertEquals(test, listTest);
    }

}