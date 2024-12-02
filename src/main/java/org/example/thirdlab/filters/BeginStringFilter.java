package org.example.thirdlab.filters;

import org.example.thirdlab.interfaces.IFilter;

public class BeginStringFilter implements IFilter {
    private final String pattern;

    public BeginStringFilter(String pattern) {
        if (pattern.isEmpty()) {
            throw new IllegalArgumentException("Подстрока не может быть пустой");
        }
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public boolean apply(String str) {
        return str.startsWith(pattern);
    }

}