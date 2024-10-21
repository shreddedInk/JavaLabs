package org.example;

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
        String[] words = str.split(" ");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }


    public static String hexDecoding(String str) {
        StringBuilder result = new StringBuilder();
        String[] parts = str.split(" ");

        for (String part : parts) {
            if (part.startsWith("0x")) {
                try {
                    long decimal = Long.parseLong(part.substring(2), 16);
                    result.append(decimal).append(" ");
                } catch (NumberFormatException e) {
                    result.append(part).append(" ");
                }
            } else {
                result.append(part).append(" ");
            }
        }
        return result.toString().trim();
    }
}