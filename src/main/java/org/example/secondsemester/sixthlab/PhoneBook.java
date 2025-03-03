package org.example.secondsemester.sixthlab;

import java.util.*;

public class PhoneBook {
    private Map<Human, Set<String>> phoneBook;
    private Set<String> allNumbers;

    public PhoneBook() {
        phoneBook = new HashMap<>();
        allNumbers = new HashSet<>();
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }

    public void addHuman(Human... humans) {
        for (Human human : humans) {
            phoneBook.putIfAbsent(human, new HashSet<>());
        }
    }

    public boolean addPhoneNumber(Human human, List<String> numbers) {
        Set<String> personNumbers = phoneBook.computeIfAbsent(human, k -> new HashSet<>());
        boolean added = false;
        for (String number : numbers) {
            if (allNumbers.add(number)) {
                personNumbers.add(number);
                added = true;
            }
        }
        return added;
    }

    public void deletePhoneNumber(Human human, String number) {
        Set<String> numbers = phoneBook.get(human);
        if (numbers != null && numbers.contains(number)) {
            numbers.removeIf(num -> num.equals(number));
            allNumbers.remove(number);
            if (numbers.isEmpty()) {
                phoneBook.remove(human);
            }
        }
    }

    public Set<String> listOfNumbersOfHuman(Human human) {
        return phoneBook.getOrDefault(human, new HashSet<>());
    }

    public Human findHumanByNumber(String number) {
        for (Map.Entry<Human, Set<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(number)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Map<Human, Set<String>> findSomeoneBySurname(String surname) {
        Map<Human, Set<String>> result = new HashMap<>();
        for (Map.Entry<Human, Set<String>> entry : phoneBook.entrySet()) {
            if (entry.getKey().getSurname().startsWith(surname)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
