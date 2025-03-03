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
    private Human human4;
    private Human humanTest;
    private Student student1;

    @Before
    public void setUp() {
        collectionsDemo = new CollectionsDemo();
        human1 = new Human("Moskalenko", "Miron", "Asnadjas", 25);
        human2 = new Human("Larkov", "Slavik", "Brooo", 30);
        human3 = new Human("Moskalenko", "Beatles", "Whryyyy", 30);
        human4 = new Human("Sosiska", "V", "Teste", 30);
        humanTest = new Human("Moskalenko", "Beatles", "Whryyyy", 15);
        student1 = new Student("Typical", "Student", "Omsu", 20, "Computer Science");
        //L,M,S,T
    }

    @Test
    public void testCountOfFirstEqualsSymbols() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("apple", "aanana", "avocado"));
        assertEquals(0, collectionsDemo.countOfFirstEqualsSymbols(list, 'b'));
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
    public void testCopyWithoutChosen() {
        ArrayList<Human> list = new ArrayList<>(Arrays.asList(human1, human2, human3));
        ArrayList<Human> result = collectionsDemo.CopyWithoutChosen(list, human2);
        assertEquals(Arrays.asList(human1, human3), result);
    }

    @Test
    public void testSetWithoutInterceptions() {
        ArrayList<Set<Integer>> list = new ArrayList<>();
        list.add(new HashSet<>(Arrays.asList(1, 2, 3)));
        list.add(new HashSet<>(Arrays.asList(4, 5, 6)));
        Set<Integer> set = new HashSet<>(List.of());
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1));

        ArrayList<Set<Integer>> result = collectionsDemo.setWithoutInterceptions(list, set);
        ArrayList<Set<Integer>> result2 = collectionsDemo.setWithoutInterceptions(list, set2);
        assertEquals(Arrays.asList(new HashSet<>(Arrays.asList(1,2, 3)), new HashSet<>(Arrays.asList(4, 5, 6))), result);
        assertEquals(Arrays.asList(new HashSet<>((Arrays.asList(4,5,6)))),result2);

    }


    @Test
    public void testGetPeopleWithMaxAge() {
        ArrayList<Human> list = new ArrayList<>(Arrays.asList(human1, human2, human3, student1));
        Set<Human> result = collectionsDemo.getPeopleWithMaxAge(list);
        assertEquals(new HashSet<>(Arrays.asList(human2, human3, student1)), result);
    }

    @Test
    public void testCreateSortedListByFullName() {
        Set<Human> set = new TreeSet<>(Arrays.asList(human1, human2, human3,humanTest, student1));
        for (Human human : set) {
            System.out.println(human);
        }
        List<Human> result = collectionsDemo.createSortedListByFullName(set);
        assertEquals(Arrays.asList(human2, human3, human1, student1), result);
    }

    @Test
    public void testGetPeopleByIds() {
        Map<Integer, Human> idToHumanMap = Map.of(1, human1, 2, human2, 3, human3);
        Set<Integer> ids = Set.of(5,6);
        Set<Human> result = collectionsDemo.getPeopleByIds(idToHumanMap, ids);
        assertEquals(Set.of(), result);
    }

    @Test
    public void testGetIdsOfAdults() {
        Student student2 = new Student("Aboba", "aBOBA", "YYYYYY", 16, "Mathematics");
        Human human4 = new Human("fctik", "smthg", "EEEEEEE", 19);
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
        assertEquals(Arrays.asList(1, 2, 3, 4,6, 7), result);
    }

    @Test
    public void testCreateIdToAgeMap() {
        Map<Integer, Human> idToHumanMap = Map.of(1, human1, 2, human2, 3, human3);
        Set<Integer> ids = Set.of(1, 2);
        Map<Integer, Integer> result = collectionsDemo.createIdToAgeMap(idToHumanMap, ids);
        assertEquals(Map.of(1, 25, 2, 30), result);
    }

    @Test
    public void testCreateAgeToHumansMap(){
        Student studentTest = new Student("Typical", "Student", "Omsu", 30, "Science");

        Set<Human> humans = new HashSet<>(Arrays.asList(human1, human2, human3, humanTest, studentTest));

        Map<Integer, List<Human>> result = collectionsDemo.createAgeToHumansMap(humans);

        assertEquals(3, result.size());
    }

    @Test
    public void testCreateComplexAgeMap() {
        Human humanTest = new Human("Abpical", "a", "c", 28);
        Student studentTest = new Student("Abpical", "a", "d", 28, "Science");

        Set<Human> humans = new HashSet<>(Arrays.asList(human1, human2, human3, student1, human4, studentTest, humanTest));
        Map<Integer, Map<Character, List<Human>>> result = collectionsDemo.createComplexAgeMapByFirstLetter(humans);
        for (Human hum : humans){
            System.out.print(hum.getSurname()+" ");
            System.out.print(hum.getName()+" ");
            System.out.print(hum.getPatronymic()+" ");
            System.out.println(hum.getAge()+" ");
        }
        System.out.println("***********");

        assertEquals(4, result.size());
        assertTrue(result.containsKey(25));
        assertTrue(result.containsKey(30));
        assertTrue(result.containsKey(20));

        Map<Character, List<Human>> letterToHumansMap = result.get(28);
        assertEquals(1, letterToHumansMap.size());

        //assertEquals(Collections.singletonList(human4), letterToHumansMap.get('S'));
        assertEquals(Arrays.asList(studentTest,humanTest), letterToHumansMap.get('A'));
        //assertEquals(Collections.singletonList(human2), letterToHumansMap.get('L'));

//        human1 = new Human("Moskalenko", "Miron", "Asnadjas", 25);
//        human2 = new Human("Larkov", "Slavik", "Brooo", 30);
//        human3 = new Human("Moskalenko", "Beatles", "Whryyyy", 30);
//        human4 = new Human("Sosiska", "V", "Teste", 30);
//        humanTest = new Human("Moskalenko", "Beatles", "Whryyyy", 15);
//        student1 = new Student("Typical", "Student", "Omsu", 20, "Computer Science");
//        Human human = new Human("Acdsadsa", "sadad", "dasdas", 28);
//        Student studentTest = new Student("Abpical", "Student", "Omsu", 30, "Science");

//        //L,M,S,T
    }

}
