package org.example.secondsemester.seventhlab;

import java.io.*;

public class ArrayBinary {

    public void writeArrayToBinary(int[] array, String filePath) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeInt(array.length);
            for (int num : array) {
                dos.writeInt(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] readArrayFromBinary(String filePath) {
        int[] array = null;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            int length = dis.readInt();
            array = new int[length];

            for (int i = 0; i < length; i++) {
                array[i] = dis.readInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public void printArray(int[] array) {
        if (array != null) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            System.out.println("Массив пуст или не инициализирован.");
        }
    }
}
