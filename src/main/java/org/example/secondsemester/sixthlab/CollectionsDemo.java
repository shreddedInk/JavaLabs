package org.example.secondsemester.sixthlab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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


}
