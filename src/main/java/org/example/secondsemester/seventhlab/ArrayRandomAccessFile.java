package org.example.secondsemester.seventhlab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ArrayRandomAccessFile {

    public ArrayList<Integer> readArrayFromPosition(int start, String FILEPATH) throws FileNotFoundException {
        ArrayList<Integer> tempList = new ArrayList<>();
        try (RandomAccessFile RAF = new RandomAccessFile(FILEPATH, "r")) {
            RAF.seek(start);
            while (true) {
                try {
                    tempList.add(RAF.readInt());
                } catch (IOException e) {
                    break;
                }
            }
        }catch (FileNotFoundException e){
            throw  e;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return tempList;
    }
}
