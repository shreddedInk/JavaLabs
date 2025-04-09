package org.example.secondsemester.seventhlab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ArrayRandomAccessFileTest {

    private static final String TEST_FILE_PATH = "testArray.dat";
    private ArrayRandomAccessFile arrayRandomAccessFile;

    @BeforeEach
    void setUp() throws IOException {
        arrayRandomAccessFile = new ArrayRandomAccessFile();
        try (RandomAccessFile raf = new RandomAccessFile(TEST_FILE_PATH, "rw")) {
            raf.writeInt(10);  // Позиция 0
            raf.writeInt(20);  // Позиция 4
            raf.writeInt(30);  // Позиция 8
            raf.writeInt(40);  // Позиция 12
            raf.writeInt(50);  // Позиция 16
        }
    }

    @Test
    void testReadArrayFromPosition() throws FileNotFoundException {
        ArrayList<Integer> result = arrayRandomAccessFile.readArrayFromPosition(0, TEST_FILE_PATH);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(20);
        expected.add(30);
        expected.add(40);
        expected.add(50);
        assertEquals(expected, result);
    }

    @Test
    void testReadArrayFromPosition_StartFromMiddle() throws FileNotFoundException {
        ArrayList<Integer> result = arrayRandomAccessFile.readArrayFromPosition(8, TEST_FILE_PATH);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(30);
        expected.add(40);
        expected.add(50);
        assertEquals(expected, result);
    }

    @Test
    void testReadArrayFromPosition_FileNotFound() {;
        assertThrows(FileNotFoundException.class, () -> {
            arrayRandomAccessFile.readArrayFromPosition(0, "non_existent_file.dat");
        });
    }


    @Test
    void testReadArrayFromPosition_InvalidStartPosition() throws FileNotFoundException {
        ArrayList<Integer> result = arrayRandomAccessFile.readArrayFromPosition(100, TEST_FILE_PATH);

        assertTrue(result.isEmpty());
    }

    @AfterEach
    void tearDown() {
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }
}