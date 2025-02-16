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

    public ArrayList<Set<Integer>> setWithoutInterceptions(ArrayList<Set<Integer>> list, Set<Integer> set) {
        ArrayList<Set<Integer>> withoutInterceptions = new ArrayList<>();
        for (Set<Integer> subset : list) {
            Set<Integer> modifiedSet = new HashSet<>(subset);
            modifiedSet.removeAll(set);
            if (!modifiedSet.isEmpty()) {
                withoutInterceptions.add(modifiedSet);
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
        Collections.sort(adultIds);
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

    public Map<Integer, Map<Character, List<Human>>> createComplexAgeMap(Set<Human> humans) {
        Map<Integer, List<Human>> ageToHumansMap = createAgeToHumansMap(humans);
        Map<Integer, Map<Character, List<Human>>> ageToLetterToHumansMap = new HashMap<>();

        for (Map.Entry<Integer, List<Human>> entry : ageToHumansMap.entrySet()) {
            int age = entry.getKey();
            List<Human> humansOfAge = entry.getValue();

            Map<Character, List<Human>> letterToHumansMap = new HashMap<>();

            for (Human human : humansOfAge) {
                char firstLetter = Character.toUpperCase(human.getSurname().charAt(0));
                letterToHumansMap.computeIfAbsent(firstLetter, k -> new ArrayList<>()).add(human);
            }

            for (Map.Entry<Character, List<Human>> letterEntry : letterToHumansMap.entrySet()) {
                List<Human> sortedList = createSortedListByFullName(new HashSet<>(letterEntry.getValue()));
                Collections.reverse(sortedList);
                letterEntry.setValue(sortedList);
            }

            ageToLetterToHumansMap.put(age, letterToHumansMap);
        }

        return ageToLetterToHumansMap;
    }
}
