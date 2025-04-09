package org.example.secondsemester.seventhlab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayBinaryTest {

    private ArrayBinary array;
    private int[] arrayToWrite;
    private int[] arrayBase;
    private String filePath;
    private String filePathSymbols;
    private ArraySymbols arraySymbols;

    @Before
    public void setUp(){
        array = new ArrayBinary();
        arraySymbols = new ArraySymbols();
        arrayToWrite = new int[]{5, 10, 15, 20};
        arrayBase = new int[]{1,2,3,4,5,6};
        filePath = "D:/My projects/2kurs1Sem/LabsJava/src/main/java/org/example/secondsemester/seventhlab/integers.bin";
        filePathSymbols = "D:/My projects/2kurs1Sem/LabsJava/src/main/java/org/example/secondsemester/seventhlab/symbols.txt";
        array.writeArrayToBinary(arrayBase, filePath);
        arraySymbols.writeSymbolsArrayToTxt(arrayBase, filePathSymbols);
        arraySymbols.printArray(filePathSymbols);
    }

    @Test
    public void writeArrayToBinaryTest(){
        array.printArray(array.readArrayFromBinary(filePath));
        array.writeArrayToBinary(arrayToWrite, filePath);
        int[] array_test = array.readArrayFromBinary(filePath);
        array.printArray(array_test);
        assertArrayEquals(arrayToWrite,array.readArrayFromBinary(filePath));
    }

    @Test
    public void readArrayFromBinary(){
        assertArrayEquals(new int[]{1,2,3,4,5,6},array.readArrayFromBinary(filePath));
    }

    @Test
    public void writeSymbolsArrayToBinaryTest(){
        arraySymbols.writeSymbolsArrayToTxt(arrayToWrite, filePathSymbols);
        arraySymbols.printArray(filePathSymbols);
        assertArrayEquals(arrayToWrite, arraySymbols.readSymbolsArrayFromTxt(filePathSymbols));
    }

    @Test
    public void readSymbolsArrayFromTxtTest(){
        assertArrayEquals(arrayBase,arraySymbols.readSymbolsArrayFromTxt(filePathSymbols));
    }
}