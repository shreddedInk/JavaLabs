package org.example.thirdlab.filters;

import org.example.thirdlab.interfaces.IFilter;

public class BeginStringFilter implements IFilter {
    private final String pattern;

    public BeginStringFilter(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            throw new IllegalArgumentException("Подстрока не может быть null или пустой");
        }
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public boolean apply(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(pattern);
    }
}
