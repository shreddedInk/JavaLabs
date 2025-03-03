package org.example.secondsemester.sixthlab;

import java.util.Iterator;

public class Data implements Iterable<Integer> {
    private String symbols;
    public Group[] groups;

    public Data() {
        symbols = " ";
        groups = null;
    }

//    public Data(String str, Group[] groups) {
//        this.symbols = str;
//        this.groups = groups;
//    }

    public Data(String str, Group ... group){
        this.symbols = str;
        this.groups = group;
    }

    public String getSymbols() {
        return symbols;
    }

    public void setSymbols(String symbols) {
        this.symbols = symbols;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public int getLength() {
        return groups.length;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int cur = 0;
            int cur_gr = -1;

            @Override
            public boolean hasNext() {
                return cur < groups.length - 1 || cur_gr < groups[cur].getData().length - 1;
            }

            @Override
            public Integer next() {
                if (cur < groups.length && cur_gr < groups[cur].getData().length - 1) {
                    cur_gr++;
                } else if (cur < groups.length) {
                    cur_gr = 0;
                    cur++;
                }
                return groups[cur].getData()[cur_gr];
            }
        };

    }
}
