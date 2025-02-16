package org.example.secondsemester.sixthlab;

import java.util.*;

public class CollectionsDemo {
    public int countOfEqualsSymbols(ArrayList<String> list, char symbol){
        int count = 0;
        for (String str : list){
            if (str.charAt(0)==symbol){
                count++;
            }
        }
        return count;
    }

    public ArrayList<Human> SameSurnamesListMaker(ArrayList<Human> list, Human human){
        ArrayList<Human> surHumans = new ArrayList<Human>();
        for (Human surHuman : list){
            if (surHuman.getSurname().equals(human.getSurname())){
                surHumans.add(surHuman);
            }
        }
        return surHumans;
    }

    public ArrayList<Human> CopyWithoutChoosen(ArrayList<Human> list, Human human){
        ArrayList<Human> withoutHuman = new ArrayList<Human>();
        for (Human humans : list){
            if (!humans.equals(human)){
                withoutHuman.add(humans);
            }
        }
        return withoutHuman;
    }

    public ArrayList<Set<Integer>> setWithoutInterceptions(ArrayList<Set<Integer>> list, Set<Integer> set){
        ArrayList<Set<Integer>> withoutInterceptions = new ArrayList<Set<Integer>>();
        for (Set<Integer> integer : list){
            if (Collections.disjoint(integer, set)){
                withoutInterceptions.add(integer);
            }
        }
        return withoutInterceptions;
    }

    public Set<Human> getPeopleWithMaxAge(ArrayList<? extends Human> humanList) {
        int maxAge = 0;
        Set<Human> peopleWithMaxAge = new HashSet<Human>();
        for (Human human : humanList) {
            if (human.getAge() > maxAge) {
                maxAge = human.getAge();
            }
        }
        for (Human human : humanList) {
            if (human.getAge() == maxAge) {
                peopleWithMaxAge.add(human);
            }
        }

        return peopleWithMaxAge;
    }

    public List<Human> createSortedListByFullName(Set<? extends Human> humanSet) {
        List<Human> humanList = new ArrayList<>(humanSet);

        humanList.sort(Comparator
                .comparing(Human::getSurname)
                .thenComparing(Human::getName)
                .thenComparing(Human::getPatronymic));

        return humanList;
    }

    public Set<Human> getPeopleByIds(Map<Integer, Human> idToHumanMap, Set<Integer> ids) {
        Set<Human> resultSet = new HashSet<>();

        for (Integer id : ids) {
            if (idToHumanMap.containsKey(id)) {
                resultSet.add(idToHumanMap.get(id));
            }
        }

        return resultSet;
    }

    public List<Integer> getIdsOfAdults(Map<Integer, Human> idToHumanMap, Set<Integer> ids) {
        List<Integer> adultIds = new ArrayList<>();

        for (Integer id : ids) {
            if (idToHumanMap.containsKey(id) && idToHumanMap.get(id).getAge() >= 18) {
                adultIds.add(id);
            }
        }

        return adultIds;
    }

    public Map<Integer, Integer> createIdToAgeMap(Map<Integer, Human> idToHumanMap, Set<Integer> ids) {
        Map<Integer, Integer> idToAgeMap = new HashMap<>();

        for (Integer id : ids) {
            if (idToHumanMap.containsKey(id)) {
                idToAgeMap.put(id, idToHumanMap.get(id).getAge());
            }
        }

        return idToAgeMap;
    }

    public Map<Integer, List<Human>> createAgeToHumansMap(Set<Human> humans) {
        Map<Integer, List<Human>> ageToHumansMap = new HashMap<>();

        for (Human human : humans) {
            int age = human.getAge();

            List<Human> humansOfAge = ageToHumansMap.get(age);
            if (humansOfAge == null) {
                humansOfAge = new ArrayList<>();
                ageToHumansMap.put(age, humansOfAge);
            }

            humansOfAge.add(human);
        }

        return ageToHumansMap;
    }

}
