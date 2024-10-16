package org.example;

import java.util.regex.*;

public class StringProcessor {

    public static String copyString(String s, int N) {
        if (N < 0) {
            throw new IllegalArgumentException("N < 0");
        }
        if (s == null){
            throw  new NullPointerException("String is null");
        }
        return s.repeat(N);
    }

    public static int countEntries(String str1, String str2) {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("Вторая строка не должна быть пустой или null.");
        }
        int count = 0;
        int index = 0;
        while ((index = str1.indexOf(str2, index)) != -1) {
            count++;
            index++;
        }

        return count;
    }

    public static String replaceNumbers(String str) {
        return str.replace("1", "один")
                .replace("2", "два")
                .replace("3", "три");
    }

    public static void removeSecond(StringBuilder str) {
        int length = str.length();
        for (int i = 1; i < length; i++) {
            str.deleteCharAt(i);
            length--;
        }
    }

    public static String reverseString(String str) {
        String[] words = str.split("\\s+");
        String[] spaces = str.split("\\S+");
        StringBuilder reversed = new StringBuilder();
        int spaceIndex = 0;
        if (str.startsWith(" ")) {
            for(int i=0; i<spaces[0].length(); i++){
                reversed.append(" ");
            }
            spaceIndex = 1;
        }
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (spaceIndex < spaces.length) {
                reversed.append(spaces[spaceIndex]);
                spaceIndex++;
            }
        }
        return reversed.toString();
    }

    public static String hexDecoding(String str) {
        String regex = "0x[0-9A-Fa-f]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            String hex = matcher.group();
            long decimal = Long.parseLong(hex.substring(2), 16);
            matcher.appendReplacement(result, Long.toString(decimal));
        }
        matcher.appendTail(result);
        return result.toString();
    }
}