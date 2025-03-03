package org.example.secondsemester.sixthlab;

import java.util.ArrayList;

public class DataDemo {
    public static ArrayList<Integer> getAll(Data data){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : data){
            list.add(i);
        }
        return list;
    }
}
