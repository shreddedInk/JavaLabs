package org.example.secondsemester.eighthlab;

import org.example.secondsemester.sixthlab.Human;

import java.util.ArrayList;

public class ReflectionDemo {
    public static int SearchCountOfElementsOfHuman(ArrayList<? super Human> list){
        int count = 0;
        for (Object i : list){
            if (i instanceof Human){
                count++;
            }
        }
        return count;
    }
}
