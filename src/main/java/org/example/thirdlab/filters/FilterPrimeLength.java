package org.example.thirdlab.filters;

import org.example.thirdlab.interfaces.IFilter;

public class FilterPrimeLength implements IFilter {
    private final String pattern;

    public FilterPrimeLength(String pattern) {
        if (pattern.isEmpty()) {
            throw new IllegalArgumentException("Подстрока не может быть пустой");
        }
        this.pattern = pattern;
    }

    private boolean isPrime(String pattern) {
        int length = pattern.length();
        if (length <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(length); i++) {
            if (length % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public boolean apply(String pattern) {
        return isPrime(pattern);
    }
}
