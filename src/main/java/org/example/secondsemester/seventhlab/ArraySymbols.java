package org.example.secondsemester.seventhlab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArraySymbols {

    public void writeSymbolsArrayToTxt(int[] chars, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (int symbol : chars) {
                writer.write(symbol);
                writer.write(' ');
            }
            //System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] readSymbolsArrayFromTxt(String path) {
        List<Integer> resultList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int symbol=0;
            while ((symbol = reader.read()) != -1) {
                if (symbol != ' ') {
                    resultList.add(symbol);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for (Integer i : resultList){
//            System.out.println(i);
//        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public void printArray(String path) {
        int[] array = readSymbolsArrayFromTxt(path);
        for (int symbol : array) {
            System.out.print(symbol + " ");
        }
        System.out.println();
    }
}
