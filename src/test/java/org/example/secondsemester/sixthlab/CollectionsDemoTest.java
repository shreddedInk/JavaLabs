package org.example.secondsemester.sixthlab;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class CollectionsDemoTest {

    private CollectionsDemo collectionsDemo;
    private Human human1;
    private Human human2;
    private Human human3;
    private Student student1;

    @Before
    public void setUp() {
        collectionsDemo = new CollectionsDemo();
        human1 = new Human("Moskalenko", "Miron", "Asnadjas", 25);
        human2 = new Human("Markov", "Slavik", "Brooo", 30);
        human3 = new Human("Moskalenko", "Beatles", "Whryyyy", 30);
        student1 = new Student("Typical", "Student", "Omsu", 20, "Computer Science");
    }

    @Test
    public void testCountOfFirstEqualsSymbols() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "avocado"));
        assertEquals(2, collectionsDemo.countOfFirstEqualsSymbols(list, 'a'));
    }

    @Test
    public void testSameSurnamesListMaker() {
        ArrayList<Human> list = new ArrayList<>(Arrays.asList(human1, human2, human3));
        ArrayList<Human> result = collectionsDemo.SameSurnamesListMaker(list, human1);
        assertEquals(Arrays.asList(human1, human3), result);
    }

    @Test
    public void testSameSurnamesListMaker_EmptyList() {
        ArrayList<Human> list = new ArrayList<>();
        ArrayList<Human> result = collectionsDemo.SameSurnamesListMaker(list, human1);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testCopyWithoutChoosen() {
        ArrayList<Human> list = new ArrayList<>(Arrays.asList(human1, human2, human3));
        ArrayList<Human> result = collectionsDemo.CopyWithoutChoosen(list, human1);
        assertEquals(Arrays.asList(human2, human3), result);
    }

    @Test
    public void testSetWithoutInterceptions() {
        ArrayList<Set<Integer>> list = new ArrayList<>();
        list.add(new HashSet<>(Arrays.asList(1, 2, 3)));
        list.add(new HashSet<>(Arrays.asList(4, 5, 6)));
        Set<Integer> set = new HashSet<>(Arrays.asList(3, 6));

        ArrayList<Set<Integer>> result = collectionsDemo.setWithoutInterceptions(list, set);
        assertEquals(Arrays.asList(new HashSet<>(Arrays.asList(1, 2)), new HashSet<>(Arrays.asList(4, 5))), result);

    }


    @Test
    public void testGetPeopleWithMaxAge() {
        ArrayList<Human> list = new ArrayList<>(Arrays.asList(human1, human2, human3, student1));
        Set<Human> result = collectionsDemo.getPeopleWithMaxAge(list);
        assertEquals(new HashSet<>(Arrays.asList(human2, human3)), result);
    }

    @Test
    public void testCreateSortedListByFullName() {
        Set<Human> set = new HashSet<>(Arrays.asList(human1, human2, human3, student1));
        List<Human> result = collectionsDemo.createSortedListByFullName(set);
        assertEquals(Arrays.asList(student1, human2, human3, human1), result);
    }

    @Test
    public void testGetPeopleByIds() {
        Map<Integer, Human> idToHumanMap = Map.of(1, human1, 2, human2, 3, human3);
        Set<Integer> ids = Set.of(1, 3);
        Set<Human> result = collectionsDemo.getPeopleByIds(idToHumanMap, ids);
        assertEquals(Set.of(human1, human3), result);
    }

    @Test
    public void testGetIdsOfAdults() {
        Student student2 = new Student("Aboba", "aBOBA", "YYYYYY", 16, "Mathematics");
        Human human4 = new Human("fctik", "smthg", "EEEEEEE", 15);
        Student student3 = new Student("Stud", "Stud", "Stud", 22, "Physics");

        Map<Integer, Human> idToHumanMap = Map.of(
                1, human1,
                2, human2,
                3, human3,
                4, student1,
                5, student2,
                6, human4,
                7, student3
        );
        Set<Integer> ids = Set.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> result = collectionsDemo.getIdsOfAdults(idToHumanMap, ids);
        assertEquals(Arrays.asList(1, 2, 3, 4, 7), result);
    }

    @Test
    public void testCreateIdToAgeMap() {
        Map<Integer, Human> idToHumanMap = Map.of(1, human1, 2, human2, 3, human3);
        Set<Integer> ids = Set.of(1, 2);
        Map<Integer, Integer> result = collectionsDemo.createIdToAgeMap(idToHumanMap, ids);
        assertEquals(Map.of(1, 25, 2, 30), result);
    }

    @Test
    public void testCreateComplexAgeMap() {
        Set<Human> humans = new HashSet<>(Arrays.asList(human1, human2, human3, student1));
        Map<Integer, Map<Character, List<Human>>> result = collectionsDemo.createComplexAgeMap(humans);

        assertEquals(3, result.size());
        assertTrue(result.containsKey(25));
        assertTrue(result.containsKey(30));
        assertTrue(result.containsKey(20));

        Map<Character, List<Human>> letterToHumansMap = result.get(30);
        assertEquals(2, letterToHumansMap.size());

        assertEquals(Collections.singletonList(human3), letterToHumansMap.get('S'));
        assertEquals(Collections.singletonList(human2), letterToHumansMap.get('D'));
    }

}
