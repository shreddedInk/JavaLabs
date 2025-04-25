package org.example.firstsemester.thirdlab.filters;

import org.example.firstsemester.thirdlab.interfaces.IFilter;

public class ContainsFilter implements IFilter {
    private final String pattern;

    public ContainsFilter(String pattern) {
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
        return str.contains(pattern);
    }
}
